package com.namji.todolist.controller;

import com.namji.todolist.dto.TodoRequestDto;
import com.namji.todolist.dto.TodoResponseDto;
import com.namji.todolist.entity.Todo;
import com.namji.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public TodoResponseDto createTodo (@RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/todo")
    public List<Todo> getTodo () {
        return todoService.getTodo();
    }

    @GetMapping("/todo/{id}")
    public Optional<Todo> selectSchedule(@PathVariable Long id) {
        return todoService.selectSchedule(id);
    }
}
