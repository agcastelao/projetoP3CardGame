import java.util.Random;

public class Lobby {
    private Usuario[] jogadoresNoLobby;
    private Deck[] decksDisponiveis;
    private Arena[] partidasAtivas;
    private int jogadorCont;
    private int deckCont;
    private int partidaCont;
    private Random random;

    public Lobby() {
        jogadoresNoLobby = new Usuario[100]; // Suponha um limite de 100 jogadores
        decksDisponiveis = new Deck[100]; // Suponha um limite de 100 decks disponíveis
        partidasAtivas = new Arena[100]; // Suponha um limite de 100 partidas ativas
        jogadorCont = 0;
        deckCont = 0;
        partidaCont = 0;
        random = new Random();
    }

    public void adicionarJogadorNoLobby(Usuario jogador) {
        jogadoresNoLobby[jogadorCont] = jogador;
        jogadorCont++;
    }

    public void removerJogadorDoLobby(Usuario jogador) {
        for (int i = 0; i < jogadorCont; i++) {
            if (jogadoresNoLobby[i] == jogador) {
                // Move os jogadores subsequentes para preencher o espaço vazio
                for (int j = i; j < jogadorCont - 1; j++) {
                    jogadoresNoLobby[j] = jogadoresNoLobby[j + 1];
                }
                jogadorCont--;
                break;
            }
        }
    }

    public void adicionarDeckDisponivel(Deck deck) {
        decksDisponiveis[deckCont] = deck;
        deckCont++;
    }

    
    public void iniciarPartidaDuelo(Usuario jogador1, Usuario jogador2) {
        // Ver se tem pelo menos um jogador na partida
        if (!isJogadorNoLobby(jogador1) || !isJogadorNoLobby(jogador2)) {
            return;
        }

        // Selecionar decks para os jogadores (suponha que ambos escolham o primeiro deck)
        Deck deckJogador1 = jogador1.getDecks().get(0);
        Deck deckJogador2 = jogador2.getDecks().get(0);

        // Ver se um dos jogadores tem um deck inválido
        if (deckJogador1 == null || deckJogador2 == null) {
            return;
        }

        // Criar uma nova partida de duelo
        Arena arena = new Arena (jogador1, jogador2, deckJogador1, jogadoresNoLobby, jogadoresNoLobby, deckJogador2, deckJogador2);
        partidasAtivas[partidaCont] = arena;
        partidaCont++;

        // Remover os jogadores do lobby
        removerJogadorDoLobby(jogador1);
        removerJogadorDoLobby(jogador2);

        // Iniciar a partida de duelo
        arena.iniciarPartida();
    }

    private boolean isJogadorNoLobby(Usuario jogador) {
        for (int i = 0; i < jogadorCont; i++) {
            if (jogadoresNoLobby[i] == jogador) {
                return true;
            }
        }
        return false;
    }
    
    public void iniciarPartidaDupla() {
        // Verificar se há pelo menos 4 jogadores no lobby 
        if (jogadorCont < 4) {
            return;
        }

        // Embaralhar a lista de jogadores para seleção aleatória
        embaralharJogadores();

        // Dividir os jogadores em dois times aleatórios
        Usuario[] equipe1 = new Usuario[2];
        Usuario[] equipe2 = new Usuario[2];
        
        equipe1[0] = jogadoresNoLobby[0];
        equipe1[1] = jogadoresNoLobby[1];
        equipe2[0] = jogadoresNoLobby[2];
        equipe2[1] = jogadoresNoLobby[3];

        // Remover os jogadores das equipes do lobby
        removerJogadorDoLobby(equipe1[0]);
        removerJogadorDoLobby(equipe1[1]);
        removerJogadorDoLobby(equipe2[0]);
        removerJogadorDoLobby(equipe2[1]);

        // Selecionar decks para as equipes (suponha que cada equipe escolha o primeiro deck)
        Deck deckEquipe1 = equipe1[0].getDecks().get(0);
        Deck deckEquipe2 = equipe2[0].getDecks().get(0);

        // Criar uma nova partida dupla
        Arena arena = new Arena(null, null, deckEquipe2, equipe1, equipe2, deckEquipe1, deckEquipe2);
        partidasAtivas[partidaCont] = arena;
        partidaCont++;

        // Iniciar a partida dupla
        arena.iniciarPartida();
    }

    private void embaralharJogadores() {
        for (int i = jogadorCont - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Usuario temp = jogadoresNoLobby[i];
            jogadoresNoLobby[i] = jogadoresNoLobby[j];
            jogadoresNoLobby[j] = temp;
        }
    }
}
  


    
    
    
    


