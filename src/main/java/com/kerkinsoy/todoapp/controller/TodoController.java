package com.kerkinsoy.todoapp.controller;

import com.kerkinsoy.todoapp.dto.CreateTodoRequest;
import com.kerkinsoy.todoapp.dto.UpdateTodoRequest;
import com.kerkinsoy.todoapp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("{todoId}")
    public ResponseEntity getTodo(@PathVariable Long todoId){
        return ResponseEntity.ok((todoService.getSingleTodo(todoId)));
    }

    @GetMapping("")
    public ResponseEntity getAllTodos(){
        return ResponseEntity.ok(todoService.getUserTodos());
    }

    @PostMapping("")
    public ResponseEntity addTodo(@RequestBody CreateTodoRequest createTodoRequest){
        return ResponseEntity.ok(todoService.addTodo(createTodoRequest));
    }

    @PostMapping("/{todoId}")
    public ResponseEntity toggleTodoCompleted(@PathVariable Long todoId){

        return ResponseEntity.ok(todoService.toggleTodoCompleted(todoId));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable Long todoId){

        return ResponseEntity.ok(todoService.deleteTodo(todoId));
    }

    @PutMapping("/{todoId}")
    public ResponseEntity updateTodo(@PathVariable Long todoId, @RequestBody UpdateTodoRequest updateTodoRequest){
        return ResponseEntity.ok(todoService.updateTodo(todoId, updateTodoRequest));
    }


}
