package src.main.java.me.cu.test_rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import src.main.java.me.cu.test_rest.dto.TaskDto;
import src.main.java.me.cu.test_rest.extension.HttpStatusException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    private final Map<Long, TaskDto> tasks = new HashMap<>();
    private long nextId = 1;

    public List<TaskDto> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public void add(TaskDto task) {
        if (task.getId() != 0 && tasks.containsKey(task.getId())) {
            throw new HttpStatusException(HttpStatus.CONFLICT, "Задача с таким ID уже существует");
        }
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    public void delete(Long id) {
        if (!tasks.containsKey(id)) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, "Задача не найдена");
        }
        tasks.remove(id);
    }

    public void update(Long id, TaskDto task) {
        if (!tasks.containsKey(id)) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, "Задача не найдена");
        }
        task.setId(id);
        tasks.put(id, task);
    }
}
