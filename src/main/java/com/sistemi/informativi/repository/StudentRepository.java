package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    /*
    estendendo l'Interfaccia JpaRepository ereditiamo una serie di metodi che hanno
    già un'intelligenza intrinseca di CRUD come ad esempio i metodi save(insert/update),
    findAll(ricerca completa), deleteById(cancellazione per chiave primaria),
    findById(ricerca per chiave primaria)
     */

    /*
    La firma del metodo lastName sarà tradotta da Spring Data JPA
    nel seguente modo:
    la parola chiave find viene tradotta in "select s from Student s"
    la parola chiave By viene tradotta in "where"
    la parola LastName viene interpretata come il nome di una variabile di istanza inserita nell'Entity : "lastName"
    Il parametro di input del metodo viene tradotto come =:lastNa
     */
    public List<Student> findByLastName(String lastName);


}
