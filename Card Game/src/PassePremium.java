import java.util.List;

public class PassePremium extends Progresso {
    private int niveisNoPassePremium;

    public PassePremium() {
        this.niveisNoPassePremium = 0;
    }

    public void subirNivelNoPassePremium() {
        if (this.premiacaoAtual == 60) {
            return;
        } else {
            this.niveisNoPassePremium += 2;
            this.premiacaoAtual++;
        }
    }

    @Override
    public void entregarPremiacao() {
        List<Carta> premiacao;

        if (this.niveisNoPassePremium % 5 == 0) {
            premiacao = Loja.abrirBoosterEspecial();
        } else {
            premiacao = Loja.abrirBooster();
        }

        Inventario.adicionarCartasLiberadas(premiacao);
    }

    @Override
    public int progresso() {
        return this.niveisNoPassePremium;
    }
}



    

