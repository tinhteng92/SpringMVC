package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepo iStudentRepo;
    @Override
    public List<Student> getAll() {
        return (List<Student>) iStudentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public List<Student> getAllByName(String name) {
        return iStudentRepo.findAllByNameContaining(name);
    }

    @Override
    public void delete(int id) {
        iStudentRepo.deleteById(id);
    }

    @Override
    public Optional<Student> findById(int id) {
        return iStudentRepo.findById(id);
    }

    @Override
    public Optional<Student> findByName(String name) {
        return iStudentRepo.findByName(name);
    }
}
