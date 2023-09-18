import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int nivelAtual;
    private int quantidadeCardcoins;
    private List<Carta> cartasLiberadas;

    public Inventario() {
        this.nivelAtual = 1;
        this.quantidadeCardcoins = 0;
        this.cartasLiberadas = new ArrayList<>();
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public int getQuantidadeCardcoins() {
        return quantidadeCardcoins;
    }

    public List<Carta> getCartasLiberadas() {
        return cartasLiberadas;
    }

    public void aumentarNivel() {
        nivelAtual++;
    }

    public void adicionarCardcoins(int quantidade) {
        if (quantidade > 0) {
            quantidadeCardcoins += quantidade;
        }
    }

    public void adicionarCartasLiberadas(List<Carta> cartas) {
        cartasLiberadas.addAll(cartas);
    }
}
