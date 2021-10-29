package com.kerkinsoy.todoapp.service;

import com.kerkinsoy.todoapp.dto.CreateTodoRequest;
import com.kerkinsoy.todoapp.dto.UpdateTodoRequest;
import com.kerkinsoy.todoapp.model.Todo;
import com.kerkinsoy.todoapp.model.User;
import com.kerkinsoy.todoapp.repository.TodoRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    private final UserService userService;

    public TodoService(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    public List<Todo> getAllTodos(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        return todoRepository.findAll();
    }

    public Todo getSingleTodo(Long todoId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        return todoRepository.findById(todoId).orElseThrow(()-> new NoSuchElementException("Todo not found by id"));
    }

    public List<Todo> getUserTodos(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        return user.getTodoList();
    }

    public Todo addTodo(CreateTodoRequest createTodoRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        Todo todo = new Todo();
        todo.setUser(user);
        todo.setContent(createTodoRequest.getContent());
        user.getTodoList().add(todo);

        return todoRepository.save(todo);

    }

    public Todo toggleTodoCompleted(Long todoId){
        Todo todo = todoRepository.findById(todoId)
                    .orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());

        return todoRepository.save(todo);
    }

    public Todo deleteTodo(Long todoId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findUserByEmail(auth.getName());

        Todo todo = todoRepository.findById(todoId)
                    .orElseThrow(() -> new NoSuchElementException("Todo is not found for delete operation!"));
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);

        return todo;
    }

    public Todo updateTodo(Long todoId, UpdateTodoRequest updateTodoRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());


        //Todo todo = user.getTodoList().get(todoId);
        Todo todo = todoRepository.findById(todoId)
                    .orElseThrow(() -> new NoSuchElementException("Todo is not fount for update operation!"));

        todo.setContent(updateTodoRequest.getContent());
        todo.setCompleted(updateTodoRequest.isCompleted());
        todoRepository.save(todo);
        return todo;
    }








}
