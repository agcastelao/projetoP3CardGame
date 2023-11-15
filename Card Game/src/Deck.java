import java.util.ArrayList;
import java.util.List;

public class Deck {
    private String nome;
    private int quantidadeDeCartas;
    private boolean disponibilidade;
    private List<Carta> cartasNoDeck;
    private List<Carta> inventario;

    public Deck(String nome) {
        this.nome = nome;
        this.quantidadeDeCartas = 0;
        this.disponibilidade = false;
        this.cartasNoDeck = new ArrayList<>();
        this.inventario = new ArrayList<>();
    }
    public Carta getIndex(int index) {
        return cartasNoDeck.get(index);
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeDeCartas() {
        return quantidadeDeCartas;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void adicionarCarta(Carta carta) {
        if (quantidadeDeCartas >= 60 || (quantidadeDeCartas == 3 && !carta.getTipo().equals("mana"))) {
            throw new IrregularDeckException("O deck não pode conter mais cartas.");
        }
    
        if (quantidadeDeCartas < 3 || carta.getTipo().equals("mana")) {
            cartasNoDeck.add(carta);
            inventario.remove(carta);
            quantidadeDeCartas++;
        } else {
            throw new IrregularDeckException("A carta não está no inventário do usuário");
        }
    
        if (quantidadeDeCartas >= 60) {
            disponibilidade = true;
        }
    }

    public Carta removerCarta(Carta carta) {
        
        cartasNoDeck.remove(carta);
        inventario.add(carta);
        quantidadeDeCartas--;
        disponibilidade = false;
        return carta;
        
    } 

    public void adicionarAoInventario(Carta carta) {
        inventario.add(carta);
    }
    public List<Carta> getCartasNoDeck() {
        return cartasNoDeck;
    }
}
