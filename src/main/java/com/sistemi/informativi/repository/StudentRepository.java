package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Student;

import java.util.List;

public interface StudentRepository {


    public void addStudent(Student student);

    public void updateStudent(Student student);

    public void removeStudent(int id);

    public List<Student> findAllStudents();

    public List<Student> findAllStudentsByLastName(String lastName);



}
