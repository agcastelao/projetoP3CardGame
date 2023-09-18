public class Carta {
    private String nome;
    private String imagem;
    private String tipo;
    private String raridade;
    private int ataque;
    private int defesa;
    private int custo;
    private String habilidade;
    private int quantidade;

    public Carta(String nome, String imagem, String tipo, String raridade, int ataque, int defesa, int custo, String habilidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        setRaridade(raridade);
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
        this.quantidade = 0;
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

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        // Verificar se a raridade é válida antes de atribuir
        if (raridade.equals("comum") || raridade.equals("incomum") || raridade.equals("rara") ||
            raridade.equals("muito rara") || raridade.equals("epica")) {
            this.raridade = raridade;
        } else {
            throw new IllegalArgumentException("Raridade inválida");
        }
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

    public String getHabilidade() {
        return habilidade;
    }

    public int getQuantidade() {
        return quantidade;
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
}
