package com.sparta.todoapp.controller;

import com.sparta.todoapp.dto.TodoRequestDto;
import com.sparta.todoapp.dto.TodoResponseDto;
import com.sparta.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;
    @PostMapping("/todo")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto){
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/todo")
    public List<TodoResponseDto> getTodo(){
        return todoService.getTodo();
    }

}
