import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Usuario> obterUsuarios() {
        return usuarios;
    }

    public static Usuario obterUsuarioPorUsername(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }
}

