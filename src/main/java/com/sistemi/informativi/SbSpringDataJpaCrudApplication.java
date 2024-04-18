package com.sistemi.informativi;

import com.sistemi.informativi.entity.Student;
import com.sistemi.informativi.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbSpringDataJpaCrudApplication implements CommandLineRunner {

    private StudentService studentService;

    public SbSpringDataJpaCrudApplication(StudentService studentService) {

        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SbSpringDataJpaCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student("Giacomo","Bianchi",32);
        Student student2 = new Student("Giuseppe","Bianchi",33);
        Student student3 = new Student("Marco","Sesti",34);

        // CHECK ADD
        studentService.checkSaveOrUpdateStudent(student1);
        studentService.checkSaveOrUpdateStudent(student2);
        studentService.checkSaveOrUpdateStudent(student3);

        Student studentToUpdate = new Student(23,"Giuseppe","Bianchi",33);

        // CHECK UPDATE
        studentService.checkSaveOrUpdateStudent(studentToUpdate);

        // CHECK REMOVE
        studentService.checkRemoveStudent(24);

        // CHECK ALL STUDENTS
        studentService.checkFindAllStudents();

        // CHECK ALL STUDENTS BY LASTNAME
        studentService.checkFindAllStudentsByLastName("Bianchi");


    }
}
