package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository{

    /*
    @PersistenceContext è una annotation
    JAVA EE che deve essere utilizzata
    per inizizalizzare una variabile di
    tipo EntityManager, la quale rappresenta
    una Interfaccia ponte di comunicazione
    con Hibernate

    L'annotation @PersistenceContext va utilizzata
    al di fuori dei metodi in quanto deve essere
    seguita da una variabile di istanza di tipo
    EntityManager
     */
    @PersistenceContext
    private EntityManager em;


    @Override
    public void addStudent(Student student) {

        /*
        L'invocazione del metodo persist rappresenta
        per Hibernate la comunicazione della necessità
        di un inserimento sulla tabella student del database

        Hibernate prima di eseguire una qualsiasi operazione di CRUD ha bisogno
        di ricevere la notifica di un'avvenuta apertura di connessione
        Tale notifica si deve dare tramite annotation @Transactional

        Dopo la ricevuta della notifica Hibernate traduce il codice sottostante in:
        insert into student(first_name,last_name,age) values
        (student.getFirstName(),student.getLastName(),student.getAge());
         */
        em.persist(student);

    }


    @Override
    public void updateStudent(Student student) {

        /* Hibernate traduce in:
        update student set first_name=student.getFirstName(),
        last_name=student.getLastName(),age=student.getAge()
        where id=student.getId()
        */
        em.merge(student);

    }

    @Override
    public void removeStudent(int id) {

        /* Hibernate traduce in:
        select * from student where id=id passato in input al metodo
        */
        Student student = em.find(Student.class,id);

        /* Hibernate traduce in:
        delete from student where id=id passato in input al metodo
        */
        em.remove(student);

    }

    @Override
    public List<Student> findAllStudents() {

    // select s from Student s
    return em.createNamedQuery("Student.findAllStudents",Student.class).getResultList();

    /*
    Hibernate traduce in : select * from student
     */

    }

    @Override
    public List<Student> findAllStudentsByLastName(String lastName) {

        //"select s from Student s where s.lastName=:lastName"
        return em.createNamedQuery("Student.findAllStudentsByLastName",Student.class).
                setParameter("lastName",lastName).
                getResultList();
        //"select s from Student s where s.lastName=lastName in input al metodo"
    }


}
