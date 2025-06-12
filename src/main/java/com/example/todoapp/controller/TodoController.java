package com.example.todoapp.controller;

import com.example.todoapp.dto.todo.TodoCreateDto;
import com.example.todoapp.dto.todo.TodoResponseDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/create")
    public ResponseEntity<TodoResponseDto> addTodo(@RequestBody TodoCreateDto dto) {
        TodoResponseDto responseDto = todoService.save(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)  // ステータス201 Created
                .body(responseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
        boolean deleted = todoService.delete(id) == 1;
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}