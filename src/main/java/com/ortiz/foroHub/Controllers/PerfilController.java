package com.ortiz.foroHub.Controllers;


import com.ortiz.foroHub.domain.perfiles.DatosRegistroPerfil;
import com.ortiz.foroHub.domain.perfiles.Perfil;
import com.ortiz.foroHub.domain.perfiles.PerfilRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository repository;

    @PostMapping
    public Perfil registrar(@RequestBody @Valid DatosRegistroPerfil datos){
        var perfil = new Perfil(datos);
        return repository.save(perfil);

    }
}
