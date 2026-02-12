package infra.services;

import com.example.demo.domain.respuestas.DatosRegistroRespuesta;
import com.example.demo.domain.respuestas.Respuesta;
import com.example.demo.domain.respuestas.RespuestaRepository;
import com.example.demo.domain.topico.Topico;
import com.example.demo.domain.topico.TopicoRepository;
import com.example.demo.domain.usuarios.Usuario;
import com.example.demo.domain.usuarios.UsuarioRepository;
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
