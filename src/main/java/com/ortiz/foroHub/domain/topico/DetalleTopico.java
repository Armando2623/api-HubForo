package com.ortiz.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DetalleTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        Long usuario,
        Long curso
) {
    public DetalleTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getUsuario().getId(),
                topico.getCurso().getId());
    }
}
