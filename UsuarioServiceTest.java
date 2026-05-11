import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    private UsuarioService service;

    @BeforeEach
    public void setUp() {
        service = new UsuarioService();
    }

    @Test
    public void testCadastroUsuarioComSucesso() {
        String resultado = service.cadastrarUsuario("Jairo", "jairo@email.com");
        assertEquals("Usuário Jairo cadastrado com sucesso!", resultado);
    }

    @Test
    public void testCadastroEmailDuplicado() {
        service.cadastrarUsuario("Matheus", "matheus@email.com");
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarUsuario("Wellington", "matheus@email.com");
        });
        
        assertEquals("E-mail já cadastrado no sistema.", exception.getMessage());
    }
}
