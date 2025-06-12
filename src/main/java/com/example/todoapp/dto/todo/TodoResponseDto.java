package com.example.todoapp.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TodoResponseDto {
    private String content;
    private LocalDateTime createdAt;
}
