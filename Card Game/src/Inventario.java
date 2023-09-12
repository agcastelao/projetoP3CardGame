public class Inventario {
    private Carta[] cartas;
    private Usuario cardCoins;

    public Inventario(Usuario cardCoins){
        this.cartas = new Carta[200];
        this.cardCoins = cardCoins;
    }
}
