package domain.topico;

import com.example.demo.domain.respuestas.Respuesta;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRegistroTopico(
         String titulo,
         String mensaje,
         LocalDateTime fechaCreacion,
         Boolean estado,
         Long usuario,
         Long curso,
         @Nullable List<Respuesta> respuesta
) {
}
