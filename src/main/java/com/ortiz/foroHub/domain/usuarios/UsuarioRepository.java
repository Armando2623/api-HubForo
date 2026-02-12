package com.ortiz.foroHub.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   

    Usuario save(Usuario usuario);

    @Query("""
    SELECT u FROM Usuario u
    JOIN FETCH u.perfil
    WHERE u.correo = :correo
""")
    UserDetails findByCorreo(String correo);
}
