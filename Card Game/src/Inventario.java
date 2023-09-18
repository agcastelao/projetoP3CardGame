import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int nivelAtual;
    private int cardcoins; // Atributo renomeado para "cardcoins"
    private List<Carta> cartasLiberadas;

    public Inventario() {
        this.nivelAtual = 1;
        this.cardcoins = 0;
        this.cartasLiberadas = new ArrayList<>();
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public int getCardcoins() {
        return cardcoins;
    }

    public List<Carta> getCartasLiberadas() {
        return cartasLiberadas;
    }

    public void aumentarNivel() {
        nivelAtual++;
    }

    public void adicionarCardcoins(int quantidade) {
        if (quantidade > 0) {
            cardcoins += quantidade;
        }
    }

    public void removerCardcoins(int quantidade) {
        if (quantidade > 0 && cardcoins >= quantidade) {
            cardcoins -= quantidade;
        }
    }

    public void adicionarCartasLiberadas(List<Carta> cartas) {
        cartasLiberadas.addAll(cartas);
    }
}
