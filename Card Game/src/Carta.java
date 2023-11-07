public class Carta {
    public enum Raridade {
        COMUM(0.8),
        INCOMUM(0.15),
        RARA(0.04),
        MUITO_RARA(0.008),
        EPICA(0.002);

        private final double probabilidade;

        Raridade(double probabilidade) {
            this.probabilidade = probabilidade;
        }

        public double getProbabilidade() {
            return probabilidade;
        }
    }

    private String nome;
    private String imagem;
    private String tipo;
    private Raridade raridade;
    private int ataque;
    private int defesa;
    private int custo;
    private Habilidade habilidade;
    private int quantidade;
    private int pontosVida;
    private int mana;

    private Carta(String nome, String imagem, String tipo, Raridade raridade, int ataque, int defesa, int custo, Habilidade habilidade, int pontosVida, int mana) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
        this.quantidade = 0;
        this.pontosVida = pontosVida;
        
    }


    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getCusto() {
        return custo;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public void aumentarQuantidade() {
        if (quantidade < 3 || tipo.equals("mana")) {
            quantidade++;
        } else {
            throw new IllegalStateException("Quantidade máxima excedida");
        }
    }

    public void diminuirQuantidade() {
        if (quantidade > 0) {
            quantidade--;
        }
    }


    public int getMana() {
        return 0;
    }
}