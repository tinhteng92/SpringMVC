package com.codegym.controller;

import com.codegym.model.Classroom;
import com.codegym.model.Student;
import com.codegym.service.ClassroomService;
import com.codegym.service.StudentService;
import com.codegym.validate.ValidateEditStudent;
import com.codegym.validate.ValidateStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassroomService classroomService;

    @Autowired
    ValidateStudent validateStudent;

    @Autowired
    ValidateEditStudent validateEditStudent;


    @ModelAttribute(name = "student")
    public Student student(){
        return new Student();
    }

    @ModelAttribute(name = "classroomList")
    public List<Classroom> classrooms(){
        return classroomService.getAll();
    }

    @GetMapping("/student")
    public ModelAndView show(@RequestParam(defaultValue = "") String message) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("students", studentService.getAll());
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("students", studentService.getAllByName(search));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
//        modelAndView.addObject("branchList", branchService.getAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        validateStudent.validate(student,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        redirectAttributes.addAttribute("message", "Create successfully!");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Optional<Student> student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute("staff") Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        validateEditStudent.validate(student,bindingResult);
        if (bindingResult.hasFieldErrors()) {

            ModelAndView modelAndView = new ModelAndView("edit");

            return modelAndView;
        }
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        redirectAttributes.addAttribute("message", "Edit successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id,RedirectAttributes redirectAttributes) {
        studentService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        redirectAttributes.addAttribute("message","Delete successfully!");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetails(@PathVariable int id) {
        Optional<Student> student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

}
