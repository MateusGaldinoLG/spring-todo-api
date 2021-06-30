package com.project.todolist.todolist.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String toDo;

    @Column(nullable = false)
    private boolean done;

    @Column
    private LocalDate created_at;

    @ManyToOne(optional=false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private Users user;

}
