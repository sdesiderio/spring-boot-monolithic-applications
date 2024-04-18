package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Student;

public interface StudentService {

    public void checkSaveOrUpdateStudent(Student student);

    public void checkRemoveStudent(int id);

    public void checkFindAllStudents();

    public void checkFindAllStudentsByLastName(String lastName);
}
