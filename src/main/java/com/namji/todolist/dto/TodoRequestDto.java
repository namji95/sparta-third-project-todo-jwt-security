package com.namji.todolist.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {
    private String title;
    private String content;
    private String user;
    private String password;
}
