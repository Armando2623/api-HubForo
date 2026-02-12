package com.example.demo.controllers;

import com.example.demo.domain.respuestas.DatosRegistroRespuesta;
import com.example.demo.domain.respuestas.Respuesta;
import com.example.demo.domain.topico.TopicoRepository;
import com.example.demo.domain.usuarios.UsuarioRepository;
import com.example.demo.services.RespuestaServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaServices repo;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Respuesta registrar(@RequestBody @Valid DatosRegistroRespuesta datos){

        return repo.guardar(datos);
    }
}
