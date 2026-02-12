package domain.respuestas;

import domain.topico.Topico;
import domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    Topico topico;
    private LocalDateTime fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;
    private String solucion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Respuesta(DatosRegistroRespuesta datos, Usuario usuario, Topico topico){

        this.mensaje = datos.mensaje();
        this.solucion = datos.solucion();
        this.usuario = usuario;
        this.topico = topico;

    }
}
