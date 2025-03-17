package src.main.java.me.cu.test_rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private long id;

    @NotEmpty(message = "Название не может отстутствовать")
    private String name;

    @NotEmpty(message = "Автор не может отстутствовать")
    private String author;

    private String description;

    @NotNull(message = "Приоритет не может отстутствовать")
    private TaskPriority priority;


    public static void main(String[] args) {
        TaskDto task = new TaskDto();
        task.setId(1);
        task.setName("Задача 1");
        task.setAuthor("Автор 1");
        task.setPriority(TaskPriority.HIGH);
        System.out.println(task.getName() + task.getAuthor());
    }
}

enum TaskPriority {
    LOW, STANDARD, HIGH, CRITICAL
}
