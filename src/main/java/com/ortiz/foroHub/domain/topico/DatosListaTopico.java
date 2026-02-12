package com.ortiz.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long usuario,
        Long curso
) {

    public DatosListaTopico(Topico topico){

        this(
        topico.getId(),
        topico.getTitulo(),
        topico.getMensaje(),
        topico.getFechaCreacion(),
        topico.getUsuario().getId(),
        topico.getCurso().getId());
    }
}
