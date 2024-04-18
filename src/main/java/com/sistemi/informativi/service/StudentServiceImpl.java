package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Student;
import com.sistemi.informativi.repository.StudentRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Value("${operation.message.success}")
    private String successMessage;

    @Value("${operation.message.error}")
    private String errorMessage;

    Logger log = LoggerFactory.getLogger(this.getClass());

    /*
    Autowired Dependency Injection  (un modo)
    Tramite l'annotation @Autowired chiediamo all'ApplicationContext
    che viene eseguito all'interno dell'IoC Container di effettuare
    la seguente operazione :

    StudentRepository studentRepository = new StudentRepositoryImpl();
     */
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void checkAddStudent(Student student) {

        try {

            studentRepository.addStudent(student);
            log.info(successMessage);

        }

        catch(IllegalArgumentException | TransactionRequiredException | EntityExistsException ex){

            log.info(errorMessage);
            ex.printStackTrace();
        }



    }

    @Override
    public void checkUpdateStudent(Student student) {

        try {

            studentRepository.updateStudent(student);
            log.info(successMessage);

        }

        catch(IllegalArgumentException | TransactionRequiredException ex){

            log.info(errorMessage);
            ex.printStackTrace();
        }

    }

    @Override
    public void checkRemoveStudent(int id) {

        try {

            studentRepository.removeStudent(id);
            log.info(successMessage);

        }

        catch(IllegalArgumentException | TransactionRequiredException ex){

            log.info(errorMessage);
            ex.printStackTrace();
        }

    }

    @Override
    public void checkFindAllStudents() {

        List<Student> students = studentRepository.findAllStudents();

        if(students!=null && !students.isEmpty()){

            for (Student student : students) {

                log.info(student.toString());
            }

        }

        else {

            log.info(errorMessage);
        }

    }

    @Override
    public void checkFindAllStudentsByLastName(String lastName) {

        List<Student> students = studentRepository.findAllStudentsByLastName(lastName);

        if(students!=null && !students.isEmpty()){

            for (Student student : students) {

                log.info(student.toString());
            }

        }

        else {

            log.info(errorMessage);
        }

    }
}
