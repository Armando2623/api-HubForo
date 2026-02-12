package com.ortiz.foroHub.domain.perfiles;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPerfil(
        @NotBlank String nombre
        ) {
}
