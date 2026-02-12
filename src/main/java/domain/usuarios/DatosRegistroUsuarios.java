package domain.usuarios;

import domain.perfiles.Perfil;


public record DatosRegistroUsuarios(
         String nombre,
         String correo,
         String contrasenia,
         Perfil perfil
) {
}
