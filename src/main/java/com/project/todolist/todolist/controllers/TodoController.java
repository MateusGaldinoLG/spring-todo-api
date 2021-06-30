package com.project.todolist.todolist.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.project.todolist.todolist.entities.Todos;
import com.project.todolist.todolist.entities.Users;
import com.project.todolist.todolist.exceptions.UserNotFoundException;
import com.project.todolist.todolist.repositories.TodoRepository;
import com.project.todolist.todolist.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;
    
    @GetMapping("/users")
    public List<Users> listAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}/todos")
    public List<Todos> listTodosById(@PathVariable Long id){
        if(userRepository.existsById(id)){
            Users todoUser = userRepository.findById(id).orElse(null);
            return todoRepository.findAllByUser(todoUser);
        }

        return null;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Users insertUser(@RequestBody Users user){
        System.out.println(user);
        return userRepository.save(user);
    }

    @PostMapping("/{id}/add")
    public Todos addTodo(@RequestBody Todos todo, @PathVariable Long id ) throws UserNotFoundException{
        System.out.println(todo);
        todo.setCreated_at(LocalDate.now(ZoneId.of("America/Sao_Paulo")));
        if(userRepository.existsById(id)){
            Users todoUser = userRepository.findById(id).orElse(null);
            todo.setUser(todoUser);
            return todoRepository.save(todo); 
        }

        return null;
    }
}
