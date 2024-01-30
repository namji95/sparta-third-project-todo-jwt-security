package com.namji.todolist.service;

import com.namji.todolist.dto.TodoRequestDto;
import com.namji.todolist.dto.TodoResponseDto;
import com.namji.todolist.entity.Todo;
import com.namji.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Todo> getTodo() {
        return todoRepository.findAll();
    }

    public Optional<Todo> selectSchedule(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("일치하는 아이디가 없습니다 : " + id);
        });

        return todoRepository.findById(todo.getId());
    }

    public TodoResponseDto updateTodo(Long id, TodoRequestDto requestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하는 아이디가 없습니다 : " + id);
        });

        todo.update(requestDto);

        Todo updateTodo = todoRepository.save(todo);

        TodoResponseDto responseDto = new TodoResponseDto(updateTodo);

        return responseDto;
    }

    public String deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 아이디 입니다 : " + id);
        });

        todoRepository.delete(todo);

        return "해당 아이디가 삭제되었습니다.";
    }
}
