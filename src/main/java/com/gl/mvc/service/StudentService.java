package com.gl.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.mvc.dao.StudentDAO;
import com.gl.mvc.model.Student;

 
@Service
@Transactional
public class StudentService{
 
    @Autowired
    private StudentDAO studentDAO;
 
    
    @Transactional
    public void addStudent(Student student) {
    	studentDAO.addStudent(student);
    }
 
    
    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudentes();
    }
 
    @Transactional
    public void deleteStudent(Integer studentId) {
    	studentDAO.deleteStudent(studentId);
    }
 
    public Student getStudent(int studentId) {
        return studentDAO.getStudent(studentId);
    }
 
    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }
 
    public void setStudentsDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
 
}
