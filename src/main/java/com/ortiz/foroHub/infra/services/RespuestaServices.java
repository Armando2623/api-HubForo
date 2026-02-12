package com.ortiz.foroHub.infra.services;

import com.ortiz.foroHub.domain.respuestas.DatosRegistroRespuesta;
import com.ortiz.foroHub.domain.respuestas.Respuesta;
import com.ortiz.foroHub.domain.respuestas.RespuestaRepository;
import com.ortiz.foroHub.domain.topico.Topico;
import com.ortiz.foroHub.domain.topico.TopicoRepository;
import com.ortiz.foroHub.domain.usuarios.Usuario;
import com.ortiz.foroHub.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaServices {

    @Autowired
    private RespuestaRepository repo;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Respuesta guardar(DatosRegistroRespuesta rep){
        Topico topico = topicoRepository.getReferenceById(rep.topicoId());
        Usuario usuario = usuarioRepository.getReferenceById(rep.usuarioId());
        Respuesta respuesta = new Respuesta(rep,usuario,topico);
        repo.save(respuesta);
        // actualizar tópico
        topico.setTotalRespuestas(topico.getTotalRespuestas()+1);
        topicoRepository.save(topico);

        return respuesta;
    }
}
