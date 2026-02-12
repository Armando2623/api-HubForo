package domain.perfiles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nombre;


    public Perfil(DatosRegistroPerfil DRPerfil) {
        this.nombre = DRPerfil.nombre();
    }
}
