import java.util.List;

public class UI {
    public static void main(String[] args) {
        // Criar um novo usuário
        Usuario usuario1 = Usuario.getInstance("Playereu", "123456789", "12345", 25, 'M', "usuario1@example.com");

        // Adicionar o usuário ao gerenciador
        GerenciadorUsuarios.adicionarUsuario(usuario1);  

        // Obter a lista de usuários
        List<Usuario> listaUsuarios = GerenciadorUsuarios.obterUsuarios();

        // Exemplo de como obter um usuário por username
        Usuario usuarioEncontrado = GerenciadorUsuarios.obterUsuarioPorUsername("usuario1");

        if (usuarioEncontrado != null) {
            System.out.println("Usuário: " + usuarioEncontrado.getUsername());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}

