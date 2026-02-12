package domain.usuarios;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository {
    UserDetails findByCorreo(String correo);

}
