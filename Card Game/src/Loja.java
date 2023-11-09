import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loja {
    private String numeroDoCartao;
    private String codigoVerificador;
    private Inventario inventario;
    private boolean promocao;
    private static final int CUSTO_BOOSTER = 100;
    private static final int CUSTO_BOOSTER_ESPECIAL = 150; // 50% mais caro
    private static final int LIMITE_CARTAS = 3;

    public Loja(String numeroDoCartao, String codigoVerificador, Inventario inventario) {
        this.numeroDoCartao = numeroDoCartao;
        this.codigoVerificador = codigoVerificador;
        this.inventario = inventario;
        this.promocao = false; // Inicialmente, a promoção não está ativa
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void ativarPromocao() {
        promocao = true;
    }

    public void desativarPromocao() {
        promocao = false;
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
            throw new InsuficientCoinException("Saldo insuficiente de cardcoins para comprar um booster");
        }
    }

    public void comprarBoosterEspecial() {
        if (inventario.getCardcoins() >= CUSTO_BOOSTER_ESPECIAL) {
            inventario.removerCardcoins(CUSTO_BOOSTER_ESPECIAL);
            List<Carta> cartasDoBooster = abrirBoosterEspecial();

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
            throw new IllegalStateException("Saldo insuficiente de cardcoins para comprar um booster especial");
        }
    }

    private List<Carta> abrirBooster() {
        List<Carta> cartasDoBooster = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            int indiceAleatorio = random.nextInt(200); // Suponha que existam 200 cartas no jogo
            Carta cartaAleatoria = new Carta("Carta Única", "Imagem", "Tipo", "Raridade", 1, 1, 1, null);
            cartasDoBooster.add(cartaAleatoria);
        }

        return cartasDoBooster;
    }

    private List<Carta> abrirBoosterEspecial() {
        List<Carta> cartasDoBooster = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            int indiceAleatorio = random.nextInt(200); // Suponha que existam 200 cartas no jogo
            Carta cartaAleatoria;

            if (promocao && random.nextDouble() <= 0.01) { // Probabilidade de 1%
                cartaAleatoria = new CartaUnique("Carta Única", "Imagem", "Tipo", "Raridade", 1, 1, 1, null);
            } else {
                cartaAleatoria = new Carta("Carta Única", "Imagem", "Tipo", "Raridade", 1, 1, 1, null);
            }

            cartasDoBooster.add(cartaAleatoria);
        }

        return cartasDoBooster;
    }
}
