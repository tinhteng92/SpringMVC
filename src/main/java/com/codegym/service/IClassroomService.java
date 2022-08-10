package com.codegym.service;

import com.codegym.model.Classroom;
import com.codegym.model.Student;

import java.util.List;


public interface IClassroomService {
    List<Classroom> getAll();
    void save(Classroom classroom);
    Classroom findById(int idC);
}
