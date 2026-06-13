package SerieBobEsponja.BobEsponja.Exception;

import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.RESTPersonajesController;

import SerieBobEsponja.BobEsponja.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonajeNotFound.class)
    public ResponseEntity<String> handleNotFound(PersonajeNotFound e ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
