package com.project.todolist.todolist.repositories;

import java.util.List;

import com.project.todolist.todolist.entities.Todos;
import com.project.todolist.todolist.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Long> {
    List<Todos> findAllByUser(Users user);
}
