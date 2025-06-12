package com.example.todoapp.service;

import com.example.todoapp.dto.todo.TodoCreateDto;
import com.example.todoapp.dto.todo.TodoResponseDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public TodoResponseDto save(TodoCreateDto dto) {
        Todo todo = new Todo(dto.getContent());
        todoRepository.save(todo);
        return new TodoResponseDto(todo.getContent(), todo.getCreatedAt());
    }

    public int delete(int id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return 1;
        }
        return 0;
    }
}
