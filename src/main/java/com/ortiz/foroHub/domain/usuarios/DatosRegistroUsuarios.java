package com.ortiz.foroHub.domain.usuarios;


public record DatosRegistroUsuarios(
         String nombre,
         String correo,
         String contrasenia,
         Long perfilId
) {
}
