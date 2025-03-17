package src.main.java.me.cu.test_rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.main.java.me.cu.test_rest.dto.TaskDto;
import src.main.java.me.cu.test_rest.service.TaskService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Tag(name = "Task", description = "Управление задачами")
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получение всех задач")
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAll();
    }

    @Operation(summary = "Создание новой задачи")
    @PostMapping
    public void addTask(@RequestBody TaskDto task) {
        System.out.println("Добавление задачи: " + task);
        taskService.add(task);
    }

    @Operation(summary = "Обновление задачи")
    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody TaskDto task) {
        System.out.println("Обновление задачи (ID " + id + "): " + task);
        taskService.update(id, task);
    }

    @Operation(summary = "Удаление задачи")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        System.out.println("Удаление задачи (ID " + id + ")");
        taskService.delete(id);
    }
}
