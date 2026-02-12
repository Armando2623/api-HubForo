package com.ortiz.foroHub.Controllers;

import com.ortiz.foroHub.domain.perfiles.PerfilRepository;
import com.ortiz.foroHub.domain.usuarios.DatosRegistroUsuarios;
import com.ortiz.foroHub.domain.usuarios.Usuario;
import com.ortiz.foroHub.infra.services.UsuarioServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServices repository;

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    public Usuario registrar(@RequestBody @Valid DatosRegistroUsuarios datos){
       var perfil = perfilRepository.getReferenceById(datos.perfilId());
        var usuario = new Usuario(datos, perfil);
        return repository.guardar(usuario);

    }
}



