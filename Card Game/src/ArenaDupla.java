import java.util.Random;

public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;
    private Carta[] aliadosJogador3;
    private Carta[] aliadosJogador4;

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4, Deck deckJogador1, Deck deckJogador2, Deck deckequipe1, Deck deckequipe2) {
        super(jogador1, jogador2, deckJogador1, deckJogador2, deckequipe1, deckequipe2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.aliadosJogador3 = new Carta[5]; 
        this.aliadosJogador4 = new Carta[5]; 
    }

    @Override
    public void saque() {
        Random random = new Random();
        
        // Saque para jogador1
        for (int i = 0; i < 7; i++) {
            if (deckJogador1.getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(deckJogador1.getQuantidadeDeCartas());
                Carta cartaComprada = deckJogador1.getCartasNoDeck().remove(indiceCartaAleatoria);
                maoJogador1[i] = cartaComprada;
            }
        }

        // Saque para jogador2
        for (int i = 0; i < 7; i++) {
            if (deckJogador2.getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(deckJogador2.getQuantidadeDeCartas());
                Carta cartaComprada = deckJogador2.getCartasNoDeck().remove(indiceCartaAleatoria);
                maoJogador2[i] = cartaComprada;
            }
        }

        // Saque para jogador3
        for (int i = 0; i < 7; i++) {
            if (deckequipe1.getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(deckequipe1.getQuantidadeDeCartas());
                Carta cartaComprada = deckequipe1.getCartasNoDeck().remove(indiceCartaAleatoria);
                aliadosJogador3[i] = cartaComprada;
            }
        }

        // Saque para jogador4
        for (int i = 0; i < 7; i++) {
            if (deckequipe2.getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(deckequipe2.getQuantidadeDeCartas());
                Carta cartaComprada = deckequipe2.getCartasNoDeck().remove(indiceCartaAleatoria);
                aliadosJogador4[i] = cartaComprada;
            }
        }
    }

    @Override
    public void iniciarPartida() {
        // Sortear o jogador inicial
        Random random = new Random();
        int jogadorInicial = random.nextInt(4); // Sorteia um número de 0 a 3
        
        if (jogadorInicial == 0) {
            System.out.println("Jogador 1 começa.");
            turno(jogador1, jogador2, aliadosJogador3, aliadosJogador4);
        } else if (jogadorInicial == 1) {
            System.out.println("Jogador 2 começa.");
            turno(jogador2, jogador1, aliadosJogador4, aliadosJogador3);
        } else if (jogadorInicial == 2) {
            System.out.println("Jogador 3 começa.");
            turno(jogador3, jogador4, aliadosJogador3, aliadosJogador4);
        } else {
            System.out.println("Jogador 4 começa.");
            turno(jogador4, jogador3, aliadosJogador4, aliadosJogador3);
        }
    }

    // Sobrecarregando o método turno para lidar com aliados
    public void turno(Usuario jogadorAtual, Usuario jogadorInimigo, Carta[] aliadosJogadorAtual, Carta[] aliadosJogadorInimigo) {
        System.out.println("Turno do jogador " + jogadorAtual.getNome() + ":");

        // Lógica do turno aqui

        if (verificaFimDePartida()) {
            verificarQuemvenceuapartida();
            finalizarPartida();
            return;
        }

        // Passar o turno para o próximo jogador
        if (jogadorAtual == jogador1) {
            turno(jogador2, jogador1, aliadosJogador4, aliadosJogador3);
        } else if (jogadorAtual == jogador2) {
            turno(jogador3, jogador4, aliadosJogador3, aliadosJogador4);
        } else if (jogadorAtual == jogador3) {
            turno(jogador4, jogador3, aliadosJogador4, aliadosJogador3);
        } else {
            turno(jogador1, jogador2, aliadosJogador3, aliadosJogador4);
        }
    }
}

