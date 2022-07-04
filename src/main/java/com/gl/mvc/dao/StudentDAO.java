package com.gl.mvc.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.mvc.model.Student;
 
 
@Repository
public class StudentDAO{
 
    @Autowired
    private SessionFactory sessionFactory;
    
 
    public void addStudent(Student studente) {
        sessionFactory.getCurrentSession().saveOrUpdate(studente);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudentes() {
 
        return sessionFactory.getCurrentSession().createQuery("from Student")
                .list();
    }
 
    public void deleteStudent(Integer studenteId) {
        Student employee = (Student) sessionFactory.getCurrentSession().load(
                Student.class, studenteId);
        if (null != studenteId) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
 
    }
 
    public Student getStudent(int studenteId) {
        return (Student) sessionFactory.getCurrentSession().get(
                Student.class, studenteId);
    }
 
    public Student updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
        return student;
    }
 
}
