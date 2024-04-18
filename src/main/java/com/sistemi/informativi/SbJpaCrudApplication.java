package com.sistemi.informativi;

import com.sistemi.informativi.entity.Student;
import com.sistemi.informativi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbJpaCrudApplication implements CommandLineRunner {


    /*
    Constructor Dependency Injection
    1. dichiarazione di una variabile di istanza del tipo Interfaccia Padre della Classe che deve essere istanziata
    2. Implementazione di un Costruttore Custom all'interno del quale viene settato il valore della variabile di istanza
     */
    private final StudentService studentService;

    public SbJpaCrudApplication(StudentService studentService){

        this.studentService=studentService;
    }




    public static void main(String[] args) {

        SpringApplication.run(SbJpaCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //NEW
        Student student1 = new Student("Giada","Lauri",23);

        //NEW
        Student student2 = new Student("Maria","Lauri",24);

        //NEW
        Student student3 = new Student("Marco","Proto",25);

        //NEW
        Student student4 = new Student("Giuseppe","Verdi",30);


        //TEST INSERT
        studentService.checkAddStudent(student1);
        studentService.checkAddStudent(student2);
        studentService.checkAddStudent(student3);
        studentService.checkAddStudent(student4);

        Student studentToUpdate = new Student(2,"Maria","Lauri",25);

        //TEST UPDATE
        studentService.checkUpdateStudent(studentToUpdate);

        // TEST REMOVE
        studentService.checkRemoveStudent(3);

        // TEST READ ALL
        studentService.checkFindAllStudents();

        // TEST READ BY LASTNAME
        studentService.checkFindAllStudentsByLastName("Lauri");



    }
}
