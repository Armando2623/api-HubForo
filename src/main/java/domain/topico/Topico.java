package domain.topico;

import domain.curso.Curso;
import domain.respuestas.Respuesta;
import domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Table(name = "topicos")
@Entity(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    private Integer totalRespuestas = 0;

    public Topico (DatosRegistroTopico datos, Usuario usuario, Curso curso){
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = datos.fechaCreacion();
        this.estado = true;
        this.usuario = usuario;
        this.curso = curso;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Integer getTotalRespuestas() {
        return totalRespuestas;
    }

    public void setTotalRespuestas(int totalRespuestas) {
        this.totalRespuestas = totalRespuestas;
    }

//    public Object getFechaCreacion() {
//        return fechaCreacion;
//    }

    public void ActualizarInformacionTopico(DatosActualizacionTopico datos){
        if (datos.titulo()!=null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje()!= null){
            this.mensaje = datos.mensaje();
        }


    }
    public void eliminarTopico(){
        this.estado = false;
    }
}
