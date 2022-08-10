package com.codegym.validate;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidateStudent implements Validator {
    @Autowired
    StudentService studentService;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;

        Optional<Student> optional = studentService.findById(student.getId());
        if (optional.isPresent()) {
            errors.rejectValue("id", "error ID");
        }

    }
}
