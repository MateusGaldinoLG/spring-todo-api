package com.project.todolist.todolist.controllers;

import java.util.List;

import com.project.todolist.todolist.entities.Users;
import com.project.todolist.todolist.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    public List<Users> listAll(){
        return userRepository.findAll();
    }

    @PostMapping
    public Users insertUser(@RequestBody Users user){
        System.out.println(user);
        return userRepository.save(user);
    }
}
