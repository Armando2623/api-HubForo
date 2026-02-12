package com.ortiz.foroHub.Controllers;

import com.ortiz.foroHub.domain.curso.CursoRepository;
import com.ortiz.foroHub.domain.topico.*;
import com.ortiz.foroHub.domain.usuarios.UsuarioRepository;
import com.ortiz.foroHub.infra.services.TopicoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoServices repo;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Topico registrar(@RequestBody @Valid DatosRegistroTopico datos){
        var usuario = usuarioRepository.getReferenceById(datos.usuario());
        var curso = cursoRepository.getReferenceById(datos.curso());
        var topico = new Topico(datos, usuario, curso);
        return repo.guardar(topico);
    }

    @GetMapping("/{id}")
    public DetalleTopico detallar(@PathVariable Long id){
         Topico topico = topicoRepository.getReferenceById(id);
return new DetalleTopico(topico);
    }

    @PutMapping
    @Transactional
    public DetalleTopico actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        var topico = topicoRepository.getReferenceById(datos.id());
        topico.ActualizarInformacionTopico(datos);
    return new DetalleTopico(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public DetalleTopico elliminar(@PathVariable Long id){
            var topico = topicoRepository.getReferenceById(id);
            topico.eliminarTopico();
            return new DetalleTopico(topico);

    }

@GetMapping
    public List<DatosListaTopico> listar(){
return topicoRepository.findAllByEstadoTrue().stream()
        .map(DatosListaTopico::new)
        .toList();

}
}
