package src.main.java.me.cu.test_rest.handler;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationErrorResponse {
    private String message;
    private List<ValidationErrorDetail> details;

    public ValidationErrorResponse(String message, List<ValidationErrorDetail> details) {
        this.message = message;
        this.details = details;
    }
}
