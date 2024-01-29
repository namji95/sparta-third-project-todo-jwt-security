package com.namji.todolist.service;

import com.namji.todolist.dto.TodoRequestDto;
import com.namji.todolist.dto.TodoResponseDto;
import com.namji.todolist.entity.Todo;
import com.namji.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        // requestDto -> Entity
        Todo todo = new Todo(requestDto);

        // DB에 저장
        Todo saveTodo = todoRepository.save(todo);

        // Entity -> ResponseDto
        TodoResponseDto todoResponseDto = new TodoResponseDto(saveTodo);

        return todoResponseDto;
    }
}
