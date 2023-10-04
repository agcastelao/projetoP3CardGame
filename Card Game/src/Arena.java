import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Deck deckequipe1;
    private Deck deckequipe2;
    private Usuario[] equipe1;
    private Usuario[] equipe2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;

    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1, Usuario[] equipe1, Usuario[] equipe2, Deck deckequipe1, Deck deckequipe2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckequipe1 = deckequipe1;
        this.deckequipe2 = deckequipe2;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = null; 
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
    }

    
    public void iniciarPartida() {
        if (sortearInicio()) {
            System.out.println("Jogador 1 começa.");
            turnoJogador1();
        } else {
            System.out.println("Jogador 2 começa.");
            turnoJogador2();
        }
    }

    public void realizarAcao(Carta carta, int jogador) {
        if (jogador == 1) {
            ataque(1, 1);
        } else if (jogador == 2) {
            ataque(1, 1);
        }
    }

    
    public void verificarQuemvenceuapartida() {
        if (pontosVidaJogador1 <= 0 && pontosVidaJogador2 <= 0) {
            System.out.println("A partida foi empate");
        } else if (pontosVidaJogador1 <= 0) {
            System.out.println("O jogador 2 venceu a partida");
        } else {
            System.out.println("O jogador 1 venceu a partida");
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

    public boolean sortearInicio () {
        Random random = new Random();
        return random.nextBoolean();
    }

    public boolean turnoJogador1() {
        System.out.println("Turno do jogador 1:");
    
        compra(jogador1);
    
        posicionamento();
    
        ataque(jogador1, jogador2);
    
        if (verificaFimDePartida()) {
            verificarQuemvenceuapartida();
            finalizarPartida();
            return false;
        }
    
        turnoJogador2();
    }

    public void turnoJogador2() {
        System.out.println("Turno do jogador 2:");
    
        compra(jogador2);
    
        posicionamento();
    
        ataque(jogador2, jogador1);
    
        if (verificaFimDePartida()) {
            verificarQuemvenceuapartida();
            finalizarPartida();
            return;
        }
    
        turnoJogador1();
    }

    private void compra(Usuario jogador22) {
    }


    public void comprar() {
        Random random = new Random();
        if (turnoJogador1()) {
            if (deckJogador1.getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(deckJogador1.getQuantidadeDeCartas());
                Carta cartaComprada = deckJogador1.getCartasNoDeck().remove(indiceCartaAleatoria);
                maoJogador1[9] = cartaComprada; 
                manaMaximaJogador1++; 
            }
        } else {
            if (deckJogador2.getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(deckJogador2.getQuantidadeDeCartas());
                Carta cartaComprada = deckJogador2.getCartasNoDeck().remove(indiceCartaAleatoria);
                maoJogador2[9] = cartaComprada;
                manaMaximaJogador2++; 
            }
        }
    }

    public void posicionamento() {
        Random random = new Random();
        int posicaoMao = turnoJogador1() ? 9 : 4;
        Carta cartaPosicionada = turnoJogador1() ? maoJogador1[posicaoMao] : maoJogador2[posicaoMao];

        if (cartaPosicionada != null) {
            if (cartaPosicionada.getTipo().equals("Mana")) {
                if (turnoJogador1() && manaMaximaJogador1 > 0) {
                    manaMaximaJogador1--;
                } else if (!turnoJogador1() && manaMaximaJogador2 > 0) {
                    manaMaximaJogador2--;
                }
            } else {
                int linha = turnoJogador1() ? 1 : 0;
                int posicaoCampo = random.nextInt(5); 
                campoJogador1[linha][posicaoCampo] = cartaPosicionada; 
                maoJogador1[posicaoMao] = null;
            }
        }
    }

    public void ataque(Usuario jogador22, Usuario jogador12) {
        for (int i = 0; i < 5; i++) {
            Carta cartaAtacante = jogador22[i];
            Carta cartaDefensora = jogador12[i];

            if (cartaAtacante != null && cartaDefensora != null) {
                int dano = cartaAtacante.getAtaque() - cartaDefensora.getDefesa();
                if (dano > 0) {

                    cartaDefensora.setPontosVida(cartaDefensora.getPontosVida() - dano);

                    if (cartaDefensora.getPontosVida() <= 0) {
                        jogador12[i] = null;
                    }
                }
            }
        }
    }

    public boolean cartaJaNaMao(int[] indicesCartas, int indice) {
        for (int i = 0; i < indicesCartas.length; i++) {
            if (indicesCartas[i] == indice) {
                return true;
            }
        }
        return false;
    }

}
