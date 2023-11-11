public abstract class Progresso {
    String premiacoes[] = new String[60];
    int premiacaoAtual = 0;

    public void entregarPremiacao() {

    }

    public int progresso() {
        return this.premiacaoAtual;
    }
}
