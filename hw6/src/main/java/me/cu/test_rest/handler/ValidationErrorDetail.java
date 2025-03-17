package src.main.java.me.cu.test_rest.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationErrorDetail {
    private String field;
    private String error;
}
