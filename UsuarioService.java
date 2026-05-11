import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<String> emailsCadastrados = new ArrayList<>();

    public String cadastrarUsuario(String nome, String email) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail não pode ser vazio.");
        }
        if (emailsCadastrados.contains(email)) {
            throw new IllegalArgumentException("E-mail já cadastrado no sistema.");
        }
        
        emailsCadastrados.add(email);
        return "Usuário " + nome + " cadastrado com sucesso!";
    }
}
