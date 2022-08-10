package com.codegym.repository;


import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


public interface IStudentRepo extends CrudRepository<Student, Integer> {
   List<Student> findAllByNameContaining(String name);

    Optional<Student> findByName(String name);
}
