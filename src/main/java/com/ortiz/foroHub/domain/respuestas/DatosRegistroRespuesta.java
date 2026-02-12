package com.ortiz.foroHub.domain.respuestas;

public record DatosRegistroRespuesta(
        String mensaje,
        Long topicoId,
        Long usuarioId,
        String solucion
) {
}
