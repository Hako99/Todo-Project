package com.sparta.todoapp.service;

import com.sparta.todoapp.dto.TodoRequestDto;
import com.sparta.todoapp.dto.TodoResponseDto;
import com.sparta.todoapp.entity.Todo;
import com.sparta.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = todoRepository.save(new Todo(requestDto));
        return  new TodoResponseDto(todo);
    }

    public List<TodoResponseDto> getTodo() {
        List<Todo> todoList = todoRepository.findAll();
        List<TodoResponseDto> responseDtoList = new ArrayList<>();

        for(Todo todo : todoList){
            responseDtoList.add(new TodoResponseDto(todo));
        }
        return responseDtoList;
    }
}
