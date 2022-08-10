package com.codegym.repository;

import com.codegym.model.Classroom;

import org.springframework.data.repository.CrudRepository;


public interface IClassroomRepo extends CrudRepository<Classroom, Integer> {


}
