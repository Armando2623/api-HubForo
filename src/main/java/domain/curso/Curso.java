package domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    String nombre;
    String categoria;

    public Curso(DatosRegistroCurso DRCurso) {

        this.nombre = DRCurso.nombre();
        this.categoria = DRCurso.categoria();
    }
}