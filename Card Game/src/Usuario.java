import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String username;
    private String CPF;
    private String senha;
    private int idade;
    private char sexo;
    private String email;
    private int nivel;
    private int saldoCardcoins;
    private List<Carta> inventario;
    private List<Deck> decks;

    // Instância única do usuário (usando o padrão Singleton)
    private static Usuario instance;

    private Usuario(String username, String CPF, String senha, int idade, char sexo, String email) {
        this.username = username;
        this.CPF = CPF;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nivel = 1;
        this.saldoCardcoins = 0;
        this.inventario = new ArrayList<>();
        this.decks = new ArrayList<>();
    }

    // Método para obter a instância única do usuário (Singleton)
    public static Usuario getInstance(String username, String CPF, String senha, int idade, char sexo, String email) {
        if (instance == null) {
            instance = new Usuario(username, CPF, senha, idade, sexo, email);
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getCPF() {
        return CPF;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public int getNivel() {
        return nivel;
    }

    public int getSaldoCardcoins() {
        return saldoCardcoins;
    }

    public List<Carta> getInventario() {
        return inventario;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void aumentarNivel() {
        nivel++;
    }

    public void adicionarCardcoins(int quantidade) {
        if (quantidade > 0) {
            saldoCardcoins += quantidade;
        }
    }

    public void adicionarCartasAoInventario(List<Carta> cartas) {
        inventario.addAll(cartas);
    }

    public void adicionarDeck(Deck deck) {
        if (decks.size() < 5) {
            decks.add(deck);
        } else {
            throw new IllegalStateException("Você já possui o número máximo de decks.");
        }
    }
}
