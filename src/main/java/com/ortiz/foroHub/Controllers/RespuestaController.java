package com.ortiz.foroHub.Controllers;

import com.ortiz.foroHub.domain.respuestas.DatosRegistroRespuesta;
import com.ortiz.foroHub.domain.respuestas.Respuesta;
import com.ortiz.foroHub.domain.topico.TopicoRepository;
import com.ortiz.foroHub.domain.usuarios.UsuarioRepository;
import com.ortiz.foroHub.infra.services.RespuestaServices;
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
