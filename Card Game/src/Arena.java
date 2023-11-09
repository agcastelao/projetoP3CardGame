import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Arena {
    private Timer timerJogador1;
    private Timer timerJogador2;
    private boolean jogador1Timeout = false;
    private boolean jogador2Timeout = false;
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Deck deckequipe1;
    private Deck deckequipe2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;
    private Carta[] maoJogador1 = new Carta[11];
    private Carta[] maoJogador2 = new Carta[11];
    private int manaMaximaJogador1 = 0;
    private int manaMaximaJogador2 = 0;
    private Carta[] cemiterioJogador1 = new Carta[100];
    private Carta[] cemiterioJogador2 = new Carta[100];

    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1, Usuario[] equipe1, Usuario[] equipe2, Deck deckequipe1, Deck deckequipe2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckequipe1 = deckequipe1;
        this.deckequipe2 = deckequipe2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
        this.timerJogador1 = new Timer();
        this.timerJogador2 = new Timer();
    }

    public Arena(Usuario jogador12, Usuario jogador22, Deck deckJogador12, Deck deckJogador22, Deck deckequipe12,
            Deck deckequipe22) {
    }

    public void iniciarPartida() throws Exception {
        if (sortearInicio()) {
            System.out.println("Jogador 1 começa.");
            iniciarTemporizador(jogador1, timerJogador1);
            turnoJogador1();
        } else {
            System.out.println("Jogador 2 começa.");
            iniciarTemporizador(jogador2, timerJogador2);
            turnoJogador2();
        }
    
        if (jogador1Timeout) {
            cancelarTemporizador(timerJogador1);
            throw new TimeOutException("Timeout: O jogador 1 estourou o tempo de espera.");
        } else if (jogador2Timeout) {
            cancelarTemporizador(timerJogador2);
            throw new TimeOutException("Timeout: O jogador 2 estourou o tempo de espera.");
        }
    }
    private void iniciarTemporizador(Usuario jogador, Timer timer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (jogador == jogador1) {
                    jogador1Timeout = true;
                } else if (jogador == jogador2) {
                    jogador2Timeout = true;
                }
            }
        }, TEMPO_MAXIMO_DE_ESPERA);
    }

    

private void cancelarTemporizador(Timer timer) {
    timer.cancel();
}

    

    public void realizarAcao(Carta carta, int jogador) {
        if (jogador == 1) {
            ataque(jogador1, jogador2);
        } else if (jogador == 2) {
            ataque(jogador2, jogador1);
        }
    }

    public void verificarQuemvenceuapartida() {
        if (pontosVidaJogador1 <= 0 && pontosVidaJogador2 <= 0) {
            System.out.println("A partida foi empate");
        } else if (pontosVidaJogador1 <= 0) {
            System.out.println("O jogador 2 venceu a partida");
            jogador2.adicionarCardcoins(100);
            jogador1.adicionarCardcoins(10);
        } else {
            System.out.println("O jogador 1 venceu a partida");
            jogador1.adicionarCardcoins(100);
            jogador2.adicionarCardcoins(10);
        }
    }
    

    public boolean verificaFimDePartida() {
        return pontosVidaJogador1 <= 0 || pontosVidaJogador2 <= 0;
    }

    public void finalizarPartida() {
        if (pontosVidaJogador1 <= 0) {
            jogador2.aumentarNivel();
        } else {
            jogador1.aumentarNivel();
        }
    }

    public boolean sortearInicio() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void turnoJogador1() {
        System.out.println("Turno do jogador 1:");
        saque(jogador1);
        manaMaximaJogador1++;
        posicionamento();
        ataque(jogador1, jogador2);

        if (verificaFimDePartida()) {
            verificarQuemvenceuapartida();
            finalizarPartida();
        } else {
            turnoJogador2();
        }
    }

    public void turnoJogador2() {
        System.out.println("Turno do jogador 2:");
        saque(jogador2);
        manaMaximaJogador2++;
        posicionamento();
        ataque(jogador2, jogador1);

        if (verificaFimDePartida()) {
            verificarQuemvenceuapartida();
            finalizarPartida();
        } else {
            turnoJogador1();
        }
    }

    public void saque(Usuario jogador) {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            Deck deck = (jogador == jogador1) ? deckJogador1 : deckJogador2;
            Carta[] mao = (jogador == jogador1) ? maoJogador1 : maoJogador2;
    
            if (deck.getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(deck.getQuantidadeDeCartas());
                Carta cartaParaRemover = deck.getIndex(indiceCartaAleatoria);
                Carta cartaComprada = deck.removerCarta(cartaParaRemover);
                mao[i] = cartaComprada;
            }
        }
    }
    

    public void posicionamento() {
        Random random = new Random();
        int posicaoMao = (sortearInicio()) ? 7 : 2;
        Carta[] mao = (sortearInicio()) ? maoJogador1 : maoJogador2;
        int linha = (sortearInicio()) ? 1 : 0;
        Carta[][] campo = (sortearInicio()) ? campoJogador1 : campoJogador2;

        for (int i = 0; i < 7; i++) {
            if (mao[i] != null) {
                if (mao[i].getTipo().equals("Mana") && mao[i].getMana() <= manaMaximaJogador1) {
                    manaMaximaJogador1 -= mao[i].getMana();
                } else if (mao[i].getTipo().equals("Criatura")) {
                    int posicaoCampo = random.nextInt(5);
                    campo[linha][posicaoCampo] = mao[i];
                    mao[i] = null;
                }
            }
        }
    }

    public void ataque(Usuario jogadorAtacante, Usuario jogadorDefensor) {
        Carta[][] campoAtacante = (jogadorAtacante == jogador1) ? campoJogador1 : campoJogador2;
        Carta[][] campoDefensor = (jogadorDefensor == jogador1) ? campoJogador1 : campoJogador2;

        for (int i = 0; i < 5; i++) {
            Carta cartaAtacante = campoAtacante[1][i];
            Carta cartaDefensora = campoDefensor[0][i];

            if (cartaAtacante != null && cartaDefensora != null) {
                int dano = cartaAtacante.getAtaque() - cartaDefensora.getDefesa();
                if (dano > 0) {
                    cartaDefensora.setPontosVida(cartaDefensora.getPontosVida() - dano);

                    if (cartaDefensora.getPontosVida() <= 0) {
                        campoDefensor[0][i] = null;
                        enviarParaCemiterio(cartaDefensora, jogadorDefensor);
                    }
                }
            }
        }
    }

    public void enviarParaCemiterio(Carta carta, Usuario jogador) {
        Carta[] cemiterio = (jogador == jogador1) ? cemiterioJogador1 : cemiterioJogador2;
        for (int i = 0; i < cemiterio.length; i++) {
            if (cemiterio[i] == null) {
                cemiterio[i] = carta;
                break;
            }
        }
    }

    public Deck getDeckequipe1() {
        return deckequipe1;
    }
    public Deck getDeckequipe2() {
        return deckequipe2;
    }

    public Deck getDeckJogador1() {
        return deckJogador1;
    }

    public Deck getDeckJogador2() {
        return deckJogador2;
    }

    public Carta[] getMaoJogador1() {
        return maoJogador1;
    }

    public Carta[] getMaoJogador2() {
        return maoJogador2;
    }
    public Usuario getJogador1() {
        return jogador1;
    }

    public Usuario getJogador2() {
        return jogador2;
    }
}


