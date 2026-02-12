package com.ortiz.foroHub.Controllers;

import com.ortiz.foroHub.domain.curso.Curso;
import com.ortiz.foroHub.domain.curso.CursoRepository;
import com.ortiz.foroHub.domain.curso.DatosRegistroCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repo;

    @PostMapping
    private Curso registrar(@RequestBody @Valid DatosRegistroCurso datos){
        var curso = new Curso(datos);
        return repo.save(curso);
    }
}
