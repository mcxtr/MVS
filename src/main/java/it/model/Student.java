package it.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "students")
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

}
