package com.example.demo.controllers;

import com.example.demo.domain.curso.Curso;
import com.example.demo.domain.curso.CursoRepository;
import com.example.demo.domain.curso.DatosRegistroCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
