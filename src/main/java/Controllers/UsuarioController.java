package com.example.demo.controllers;

import com.example.demo.domain.perfiles.DatosRegistroPerfil;
import com.example.demo.domain.perfiles.Perfil;
import com.example.demo.domain.perfiles.PerfilRepository;
import com.example.demo.domain.usuarios.DatosRegistroUsuarios;
import com.example.demo.domain.usuarios.Usuario;
import com.example.demo.domain.usuarios.UsuarioRepository;
import com.example.demo.services.UsuarioServices;
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



