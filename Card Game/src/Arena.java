public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;

    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = null; // Suponha que o deck do jogador2 seja escolhido posteriormente
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
    }

    public void iniciarPartida() {
    }

    public void realizarAcao(Carta carta, int jogador) {
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
}
