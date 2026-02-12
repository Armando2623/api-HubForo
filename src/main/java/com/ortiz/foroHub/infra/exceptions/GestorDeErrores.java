package com.ortiz.foroHub.infra.exceptions;



import com.ortiz.foroHub.domain.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestorDeErrores {
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity gestionaeError404() {
//        return ResponseEntity.notFound().build();
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity gestionaeError400(MethodArgumentNotValidException ex) {
//        var errores = ex.getFieldErrors();
//        return ResponseEntity.badRequest().body(errores.stream()
//                .map(DatosErrorValidacion::new)
//                .toList());
//    }
//
//
//    public record DatosErrorValidacion(
//            String campo,
//            String mensaje) {
//        public DatosErrorValidacion(FieldError error) {
//            this(error.getField(),
//                    error.getDefaultMessage());
//        }
//
//    }
//
//  /*  @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity getionarError404() {
//        return ResponseEntity.notFound().build();
//    }
//
//   */
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity getionarError400(MethodArgumentNotValidException ex) {
//        var errores = ex.getFieldErrors();
//        return ResponseEntity.badRequest().body(errores.stream().map(DatosErrorValidacion::new).toList());
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity gestionarError400(HttpMessageNotReadableException ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity gestionarErrorBadCredentials() {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
//    }
//
//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity gestionarErrorAuthentication() {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falla en la autenticación");
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity gestionarErrorAccesoDenegado() {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acceso denegado");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity gestionarError500(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + ex.getLocalizedMessage());
//    }
//
////    public record DatosErrorValidacion(String campo, String mensaje) {
////        public DatosErrorValidacion(FieldError error) {
////            this(error.getField(), error.getDefaultMessage());
////        }

@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity tratarError404(){
    return ResponseEntity.notFound().build();
}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }
    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tratarValidacionError(ValidacionException e) {

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
