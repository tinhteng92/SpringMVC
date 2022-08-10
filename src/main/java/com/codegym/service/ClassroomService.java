package com.codegym.service;

import com.codegym.model.Classroom;
import com.codegym.repository.IClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    IClassroomRepo iClassroomRepo;

    @Override
    public List<Classroom> getAll() {
        return (List<Classroom>) iClassroomRepo.findAll();
    }

    @Override
    public void save(Classroom classroom) {

    }

    @Override
    public Classroom findById(int idC) {
        return iClassroomRepo.findById(idC).get();
    }
}
