package pe.entelgy.reto.util.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import pe.entelgy.reto.controller.response.RestResponse;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(GenericRestException.class)
    protected ResponseEntity<Object> handleGenericRestException(GenericRestException exception) {
        RestResponse response = new RestResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity<Object> handleRestException(HttpClientErrorException exception) {
        RestResponse response = new RestResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    protected ResponseEntity<Object> handleRestException(HttpServerErrorException exception) {
        RestResponse response = new RestResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
