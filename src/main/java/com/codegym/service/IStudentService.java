package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAll();
    void save(Student student);
    List<Student> getAllByName(String name);
    void delete(int id);
    Optional<Student> findById(int id);
    Optional<Student> findByName(String name);

}
