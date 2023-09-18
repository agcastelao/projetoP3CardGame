import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loja {
    private String numeroDoCartao;
    private String codigoVerificador;
    private Inventario inventario;
    private static final int CUSTO_BOOSTER = 100;

    public Loja(String numeroDoCartao, String codigoVerificador, Inventario inventario) {
        this.numeroDoCartao = numeroDoCartao;
        this.codigoVerificador = codigoVerificador;
        this.inventario = inventario;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void comprarBooster() {
        if (inventario.getCardcoins() >= CUSTO_BOOSTER) { // Onde colocar isso?
            inventario.removerCardcoins(CUSTO_BOOSTER); // Onde colocar isso?
            List<Carta> cartasDoBooster = abrirBooster();
            inventario.adicionarCartasLiberadas(cartasDoBooster);
        }
    }

    private List<Carta> abrirBooster() {
        List<Carta> cartasDoBooster = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            int indiceAleatorio = random.nextInt(200); // Suponha que existam 200 cartas no jogo
            Carta cartaAleatoria = new Carta();
            cartasDoBooster.add(cartaAleatoria);
        }

        return cartasDoBooster;
    }
}
