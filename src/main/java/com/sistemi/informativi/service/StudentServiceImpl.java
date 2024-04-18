package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Student;
import com.sistemi.informativi.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final String errorMessage = "ERROR";
    private final String successMessage = "SUCCESS";
    private Logger log = LoggerFactory.getLogger(this.getClass());

    // StudentRepository Injection
    private StudentRepository studentRepository;

    public StudentServiceImpl(final StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public void checkSaveOrUpdateStudent(Student student) {

        /*
        Possiamo invocare il metodo save sull'Interfaccia
        StudentRepository in quanto StudentRepository è
        figlia di JpaRepository e quindi lo ereditiamo

        Nel momento in cui invochiamo il metodo save
        fornito dal modulo Spring Data JPA, il Framework
        inizializza una variabile di tipo EntityManager
        e invoca o il metodo persist o il metodo merge
        in base all'Oggetto passato in input al metodo
         */

        try {

            studentRepository.save(student);

               log.info(successMessage);

        }

        catch(IllegalArgumentException | OptimisticLockingFailureException ex){

               log.info(errorMessage);

                  ex.printStackTrace();

        }

    }

    @Override
    public void checkRemoveStudent(int id) {

        try {

            studentRepository.deleteById(id);
            log.info(successMessage);

        }

        catch(IllegalArgumentException | EmptyResultDataAccessException ex){

            log.info(errorMessage);
            ex.printStackTrace();

        }

    }

    @Override
    public void checkFindAllStudents() {

        /*
        Quando invochiamo il metodo findAll Spring Data JPA
        dietro le quinte viene effettuata dal Framework una
        query JPQL: (select s from Student s) che successivamente
        viene passata ad Hibernate che la traduce in :
        select * from student
         */
        List<Student> students = studentRepository.findAll();

        if(students!=null && !students.isEmpty()){

            students.forEach(student->log.info(student.toString()));

        }

        else {

            log.info(errorMessage);
        }

    }

    @Override
    public void checkFindAllStudentsByLastName(String lastName) {

        List<Student> students = studentRepository.findByLastName(lastName);

        if(students!=null && !students.isEmpty()){

            students.forEach(student->log.info(student.toString()));

        }

        else {

            log.info(errorMessage);
        }

    }
}
