package com.example.todoapp.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoCreateDto {
    private String content;
}
