public class Usuario {
    private String user;
    private String cpf;
    private String senha;
    private int idade;
    private String sexo;
    private String email;
    private int nivel; // inicialmente 0
    private Inventario inventario;
    private Deck[] decks; // vetor de decks, 0 ate 5 posicoes
    private int cardCoins; // inicialmente 0 

    public Usuario(String user, String cpf, String senha, int idade, String sexo, String email, Inventario inventario){
        this.user = user;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nivel = 0;
        this.inventario = inventario;
        //this.deck = deck;
        this.cardCoins = 0;
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Deck[] getDecks() {
        return decks;
    }

    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }

    public int getCardCoins() {
        return cardCoins;
    }

    public void setCardCoins(int cardCoins) {
        this.cardCoins = cardCoins;
    }
}
