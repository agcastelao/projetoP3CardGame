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


    public void saque() {
        Random random = new Random();
        
        // Saque para jogador1
        for (int i = 0; i < 7; i++) {
            if (super.getDeckequipe1().getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(super.getDeckequipe1().getQuantidadeDeCartas());
                Carta cartaComprada = super.getDeckequipe1().getCartasNoDeck().remove(indiceCartaAleatoria);
                getMaoJogador1()[i] = cartaComprada;
            }
        }

        // Saque para jogador2
        for (int i = 0; i < 7; i++) {
            if (getDeckJogador2().getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(getDeckJogador2().getQuantidadeDeCartas());
                Carta cartaComprada = getDeckJogador2().getCartasNoDeck().remove(indiceCartaAleatoria);
                getMaoJogador2()[i] = cartaComprada;
            }
        }

        // Saque para jogador3
        for (int i = 0; i < 7; i++) {
            if (super.getDeckequipe1().getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(super.getDeckequipe1().getQuantidadeDeCartas());
                Carta cartaComprada = super.getDeckequipe1().getCartasNoDeck().remove(indiceCartaAleatoria);
                aliadosJogador3[i] = cartaComprada;
            }
        }

        // Saque para jogador4
        for (int i = 0; i < 7; i++) {
            if (getDeckequipe2().getQuantidadeDeCartas() > 0) {
                int indiceCartaAleatoria = random.nextInt(getDeckequipe2().getQuantidadeDeCartas());
                Carta cartaComprada = getDeckequipe2().getCartasNoDeck().remove(indiceCartaAleatoria);
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
            turno(getJogador1(), getJogador2(), aliadosJogador3, aliadosJogador4);
        } else if (jogadorInicial == 1) {
            System.out.println("Jogador 2 começa.");
            turno(getJogador2(), getJogador1(), aliadosJogador4, aliadosJogador3);
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
        System.out.println("Turno do jogador " + jogadorAtual.getUsername() + ":");

        // Lógica do turno aqui

        if (verificaFimDePartida()) {
            verificarQuemvenceuapartida();
            finalizarPartida();
            return;
        }

        // Passar o turno para o próximo jogador
        if (jogadorAtual == getJogador1()) {
            turno(getJogador2(), getJogador1(), aliadosJogador4, aliadosJogador3);
        } else if (jogadorAtual == getJogador2()) {
            turno(jogador3, jogador4, aliadosJogador3, aliadosJogador4);
        } else if (jogadorAtual == jogador3) {
            turno(jogador4, jogador3, aliadosJogador4, aliadosJogador3);
        } else {
            turno(getJogador1(), getJogador2(), aliadosJogador3, aliadosJogador4);
        }
    }
}

