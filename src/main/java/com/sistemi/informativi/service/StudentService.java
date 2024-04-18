package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Student;

import java.util.List;

public interface StudentService {


    public void checkAddStudent(Student student);

    public void checkUpdateStudent(Student student);

    public void checkRemoveStudent(int id);

    public void checkFindAllStudents();

    public void checkFindAllStudentsByLastName(String lastName);

}
