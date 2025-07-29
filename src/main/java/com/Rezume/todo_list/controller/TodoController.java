package com.Rezume.todo_list.controller;

import com.Rezume.todo_list.controller.ResourceNotFoundException;
import com.Rezume.todo_list.model.Todo;
import com.Rezume.todo_list.repository.TodoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo", description = "Operations related to todos")
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @GetMapping
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = repository.save(todo);
        System.out.println("Saved Todo ID: " + savedTodo.getId());
        return ResponseEntity.ok(savedTodo);
    }

    @Operation(summary = "Get all todos")
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        Todo existingTodo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));

        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setCompleted(updatedTodo.isCompleted());
        repository.save(existingTodo);
        return ResponseEntity.ok(existingTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));

        repository.delete(todo);
        return ResponseEntity.noContent().build();
    }
}
