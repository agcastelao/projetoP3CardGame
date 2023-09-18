import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private List<Usuario> jogadoresNoLobby;
    private List<Deck> decksDisponiveis;
    private List<Arena> partidasAtivas;

    public Lobby() {
        jogadoresNoLobby = new ArrayList<>();
        decksDisponiveis = new ArrayList<>();
        partidasAtivas = new ArrayList<>();
    }

    public void adicionarJogadorNoLobby(Usuario jogador) {
        jogadoresNoLobby.add(jogador);
    }

    public void removerJogadorDoLobby(Usuario jogador) {
        jogadoresNoLobby.remove(jogador);
    }

    public void adicionarDeckDisponivel(Deck deck) {
        decksDisponiveis.add(deck);
    }

    public void iniciarPartida(Usuario jogador) {
        // Verificar se há um adversário disponível no lobby
        for (Usuario adversario : jogadoresNoLobby) {
            if (adversario != jogador && adversario.getNivel() == jogador.getNivel()) {
                // Encontrou um adversário de nível igual
                Deck deckDoJogador = jogador.getDecks().get(0); // Suponha que o jogador escolheu o primeiro deck
                Deck deckDoAdversario = adversario.getDecks().get(0); // Suponha que o adversário escolheu o primeiro deck

                if (deckDoJogador != null && deckDoAdversario != null &&
                        deckDoJogador.getNome().equals(deckDoAdversario.getNome())) {
                    // Os jogadores têm o mesmo deck
                    Arena arena = new Arena(jogador, adversario, deckDoJogador);
                    partidasAtivas.add(arena);

                    // Remover os jogadores do lobby
                    jogadoresNoLobby.remove(jogador);
                    jogadoresNoLobby.remove(adversario);

                    // Iniciar a partida
                    arena.iniciarPartida();
                    return;
                }
            }
        }

        // Se não encontrou um adversário correspondente, o jogador aguarda no lobby
    }
}
