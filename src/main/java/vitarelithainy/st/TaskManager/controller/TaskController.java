package vitarelithainy.st.TaskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vitarelithainy.st.TaskManager.model.Task;
import vitarelithainy.st.TaskManager.model.User;
import vitarelithainy.st.TaskManager.service.TaskService;
import vitarelithainy.st.TaskManager.service.UserService;


import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @Autowired
    private UserService userService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id){
        var task = taskService.findById(Long.valueOf(id));
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task taskToCreate){
        var taskCreated = taskService.create(taskToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(taskCreated.getId().toString())
                .toUri();
        return ResponseEntity.created(location).body(taskCreated);
    }

}
