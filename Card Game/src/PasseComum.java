public class PasseComum extends Progresso{

    public void subirNivelNoPasseComum() { //usar esse metodo ao vencer
        if(this.premiacaoAtual == 60) {
            return;
        } else {
            premiacaoAtual++;
        }
    }

    public void entregarPremiacao() {
        Inventario.adicionarCartasLiberadas(Loja.abrirBooster());
    }

    //usar abrirBoster() e adicionarCartasLiberadas(List<Carta> cartas)
}
