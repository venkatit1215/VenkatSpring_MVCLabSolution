package com.gl.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gl.mvc.model.Student;
import com.gl.mvc.service.StudentService;
 
@Controller
@RequestMapping("/studentes")
public class StudentController {
 
    private static final Logger logger = Logger
            .getLogger(StudentController.class);
 
    public StudentController() {
        System.out.println("StudentController()");
    }
 
    @Autowired
    private StudentService studenteService;
 
    @RequestMapping(value = "/")
    public ModelAndView listStudents(ModelAndView model) throws IOException {
        List<Student> listStudent = studenteService.getAllStudents();
        model.addObject("studentes", listStudent);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newStudent", method = RequestMethod.GET)
    public ModelAndView newStudent(ModelAndView model) {
        Student studente = new Student();
        model.addObject("studente", studente);
        model.setViewName("StudentForm");
        return model;
    }
 
    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute Student student) {
        if (student.getStudentId() == 0) { 
            studenteService.addStudent(student);
        } else {
            studenteService.updateStudent(student);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public ModelAndView deleteStudent(HttpServletRequest request) {
        int studenteId = Integer.parseInt(request.getParameter("id"));
        studenteService.deleteStudent(studenteId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int studenteId = Integer.parseInt(request.getParameter("id"));
        Student student = studenteService.getStudent(studenteId);
        ModelAndView model = new ModelAndView("StudentForm");
        model.addObject("studente", student);
 
        return model;
    }
 
}