package SerieBobEsponja.BobEsponja.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
//Aqui es donde manejarsmos  como quieres que meustre el error
    @ExceptionHandler(ElementNotFoundException.class) // Esepcifica con que exepcion ejecutaremos
    public ResponseEntity<String> handleNotFound(ElementNotFoundException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }

    @ExceptionHandler(AddException.class)
    public ResponseEntity<String> handleAddPersonajeException (AddException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }

    @ExceptionHandler(GetPageException.class)
    public ResponseEntity<String> handleAPageException(GetPageException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }


    @ExceptionHandler(GetSizeException.class)
    public ResponseEntity<String> handleAPageException(GetSizeException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }

    @ExceptionHandler(IdInvalidException.class)
    public ResponseEntity<String> handleIdInvalidException(IdInvalidException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }

    @ExceptionHandler(StringInvalidException.class)
    public ResponseEntity<String> handleStringInvalidException(StringInvalidException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }

//   Si no encunetra un controller ocn el nombre lanzara un mensaje de error
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handleNotFound(NoResourceFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMensajes.RutaGeneral);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<String> handleRequestException(RequestException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }


    @ExceptionHandler(PrecioInvalidException.class)
    public ResponseEntity<String> handleRequestException(PrecioInvalidException e ) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND) //Codigo http de  error quer mandara
                .body(e.getMessage()); // Mensaje del error
    }
}
