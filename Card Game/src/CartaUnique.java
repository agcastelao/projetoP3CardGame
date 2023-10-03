import java.util.Random;

public class CartaUnique extends Carta {
    private String habilidadeExtra;

    public CartaUnique(String nome, String imagem, String tipo, String raridade, int ataque, int defesa, int custo) {
        super(nome, imagem, tipo, raridade, ataque + 1, defesa + 1, custo, "");
        Random random = new Random();
        setHabilidadeExtraAleatoria(random);
    }

    private void setHabilidadeExtraAleatoria(Random random) {
        String[] habilidadesExtras = {"Veneno", "Escudo", "Stun", "Invisibilidade", "Fogo", "Congelamento"};
        int index = random.nextInt(habilidadesExtras.length);
        habilidadeExtra = habilidadesExtras[index];
    }

    public String getHabilidadeExtra() {
        return habilidadeExtra;
    }

    public void setHabilidadeExtra(String habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }

}
