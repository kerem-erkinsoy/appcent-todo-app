package com.kerkinsoy.todoapp.repository;

import com.kerkinsoy.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
