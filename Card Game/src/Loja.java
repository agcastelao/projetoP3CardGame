import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loja {
    private String numeroDoCartao;
    private String codigoVerificador;
    private Inventario inventario;
    private static final int CUSTO_BOOSTER = 100;
    private static final int LIMITE_CARTAS = 3; 

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
        if (inventario.getCardcoins() >= CUSTO_BOOSTER) {
            inventario.removerCardcoins(CUSTO_BOOSTER);
            List<Carta> cartasDoBooster = abrirBooster();
            
            for (Carta carta : cartasDoBooster) {
                if (inventario.possuiCarta(carta)) {
                    if (inventario.getQuantidadeCarta(carta) < LIMITE_CARTAS) {
                        inventario.adicionarCarta(carta);
                    } else {
                        int valorCardcoins = carta.getCusto();
                        inventario.adicionarCardcoins(valorCardcoins);
                    }
                } else {
                    inventario.adicionarCartasLiberadas(cartasDoBooster);
                }
            }
        } else {
            throw new IllegalStateException("Saldo insuficiente de cardcoins para comprar um booster");
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
