package com.example.CRM.Controller;

import com.example.CRM.Model.SupportTicket;
import com.example.CRM.Model.Task;
import com.example.CRM.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Task> getTasksById(@PathVariable Long id) {
        Task tasks = taskService.getTaskById(id);
        if (tasks == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Task> createTasks(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }





//    @GetMapping
//    public List<Task> getAllTasks() {
//        return taskService.getAllTasks();
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//        Task task = taskService.getTaskById(id);
//        if (task == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(task);
//    }

//    @PostMapping
//    public Task createTask(@RequestBody Task task) {
//        return taskService.createTask(task);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
//        Task task = taskService.updateTask(id, taskDetails);
//        if (task == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(task);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//        taskService.deleteTask(id);
//        return ResponseEntity.noContent().build();
//    }
}
