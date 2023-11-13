public class PasseComum extends Progresso{

    public void subirNivelNoPasseComum() { //usar esse metodo ao vencer
        if(this.premiacaoAtual == 60) {
            return;
        } else {
            premiacaoAtual++;
        }
    }

    @Override
    public void entregarPremiacao() {
        Inventario.adicionarCartasLiberadas(Loja.abrirBooster());
    }

    @Override
    public int progresso() {
        
    }

    //usar abrirBoster() e adicionarCartasLiberadas(List<Carta> cartas)
}
