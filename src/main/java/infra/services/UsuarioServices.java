package infra.services;

import com.example.demo.domain.perfiles.Perfil;
import com.example.demo.domain.perfiles.PerfilRepository;
import com.example.demo.domain.usuarios.Usuario;
import com.example.demo.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PerfilRepository repo;


    public Usuario guardar(Usuario usuario) {

        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        Long perfilId = usuario.getPerfil().getId();
         Perfil perfil = repo
                .findById(usuario.getPerfil().getId())
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        usuario.setPerfil(perfil);
        return repository.save(usuario);
    }
}

