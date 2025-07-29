package com.Rezume.todo_list.repository;

import com.Rezume.todo_list.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface TodoRepository extends JpaRepository<Todo, Long> {
    }


