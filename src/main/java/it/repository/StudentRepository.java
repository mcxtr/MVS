package it.repository;

import it.model.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    void deleteById(Long id);
    Student findById(Long id);
    List<Student> findAll();

    void update(Student student, Long id);

}
