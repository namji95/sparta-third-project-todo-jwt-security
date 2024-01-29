package com.namji.todolist.dto;

import com.namji.todolist.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private final String title;
    private final String content;
    private final String user;
    private final LocalDateTime createdAt;

    public TodoResponseDto(Todo saveTodo) {
        this.title = saveTodo.getTitle();
        this.content = saveTodo.getContent();
        this.user = saveTodo.getUser();
        this.createdAt = saveTodo.getCreatedAt();
    }
}
