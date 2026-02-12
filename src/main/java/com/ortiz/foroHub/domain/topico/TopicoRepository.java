package com.ortiz.foroHub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository <Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    @Query("""
            select t.estado
            from Topico t
            where
            t.id = :idTopico 
            """)
    Boolean finActivoById(Long idTopico);

   List <Topico> findAllByEstadoTrue();
}
