public abstract class Progresso {
    String premiacoes[] = new String[60];
    int premiacaoAtual = 0;

    public abstract void entregarPremiacao();

    public abstract int progresso();
}
