package infra.services;

import com.example.demo.domain.topico.Topico;
import com.example.demo.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoServices {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoRepository repo;

    public Topico guardar(Topico topico) {

        if (repo.existsByTituloAndMensaje(
                topico.getTitulo(),
                topico.getMensaje())) {

            throw new RuntimeException("Tópico duplicado");
        }
        //var  usuarios = topicoRepository.getReferenceById(topico.get);

        return repo.save(topico);
    }
}
