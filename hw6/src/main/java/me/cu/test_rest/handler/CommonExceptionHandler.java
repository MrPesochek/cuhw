package src.main.java.me.cu.test_rest.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import src.main.java.me.cu.test_rest.extension.HttpStatusException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationErrorDetail> details = ex.getBindingResult().getFieldErrors().stream().map(error -> new ValidationErrorDetail(error.getField(),error.getDefaultMessage())).collect(Collectors.toList());
        ValidationErrorResponse response = new ValidationErrorResponse("Ошибка", details);
        return ResponseEntity.badRequest().body(response);
    }
}

