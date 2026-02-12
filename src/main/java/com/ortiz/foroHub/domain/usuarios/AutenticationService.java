package com.ortiz.foroHub.domain.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        return usuarioRepository.findByCorreo(userName);
        var usuario = usuarioRepository.findByCorreo(userName);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return usuario;
    }
}
