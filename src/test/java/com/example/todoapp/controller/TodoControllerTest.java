package com.example.todoapp.controller;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {
    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoController todoController;

    @Test
    void getAllTodos_shouldReturnTodoList() {
        Todo todo1 = new Todo("a");
        Todo todo2 = new Todo("b");
        List<Todo> mockTodoList = Arrays.asList(todo1, todo2);

        when(todoService.getAllTodos()).thenReturn(mockTodoList);
        List<Todo> result = todoService.getAllTodos();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("a", result.get(0).getContent());
        verify(todoService, times(1)).getAllTodos();
    }
}