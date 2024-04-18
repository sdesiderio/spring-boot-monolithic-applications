package com.sistemi.informativi.controller;

import com.sistemi.informativi.entity.Academy;
import com.sistemi.informativi.exception.CustomException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.sistemi.informativi.service.*;

/*
TEST CONSUMER
GET http://localhost:8080/rest/api/academies
GET http://localhost:8080/rest/api/academies/code/{code}
POST http://localhost:8080/rest/api/academies
PUT http://localhost:8080/rest/api/academies
DELETE http://localhost:8080/rest/api/academies/code/{code}
 */

/*
L'annotation @RestController
fa si che la Classe diventi un
Restful Web Service Provider
in grado di ricevere file JSON
e di restituire file JSON
 */
@RestController
@RequestMapping("/rest/api/academies")
public class AcademyController {

    // INJECTION SERVICE
    private AcademyService academyService;

    public AcademyController(AcademyService academyService) {
        this.academyService = academyService;
    }

    /*
     * Il Consumer per consumare l'operazione dovrà fare
     * la seguente chiamata :
     * GET http://localhost:8080/rest/api/academies
     */
    @GetMapping
    public List<Academy> findAllaAcademies() throws CustomException {

        /*
         * Nel caso positivo il metodo del Service ritorna una
         * List<Academy> che,essendo un Oggetto Java, viene
         * automaticamente convertito dall'Object Mapper
         * in un file JSON
         */
        return academyService.checkFindAllAcademies();

    }

    /*
     * Il Consumer dovrà fare, per consumare questa operazione,
     * la seguente chiamata:
     * GET http://localhost:8080/rest/api/academies/code/{code}
     * 
     * L'annotation @PathVariabile utilizzata per chiedere
     * a Spring Restful di convertire la variabile di path
     * inserita nella url del Browser da parte del consumer
     * in una variabile Java
     * 
     */
    @GetMapping("/code/{code}")
    public Academy findAcademyByCode(@PathVariable String code) throws CustomException {

        return academyService.checkFindAcademyByCode(code);
    }

    /*
     * Il Consumer dovrà fare, per consumare questa operazione,
     * la seguente chiamata:
     * POST http://localhost:8080/rest/api/academies
     */
    @PostMapping
    public Academy saveAcademy(@Valid @RequestBody Academy academy) {

        return academyService.checkSaveOrUpdated(academy);

    }

    /*
     * Il Consumer dovrà fare, per consumare questa operazione,
     * la seguente chiamata:
     * PUT http://localhost:8080/rest/api/academies
     */
    @PutMapping
    public Academy updateAcademy(@Valid @RequestBody Academy academy) {

        return academyService.checkSaveOrUpdated(academy);

    }

    /*
     * Il Consumer dovrà fare, per consumare questa operazione,
     * la seguente chiamata:
     * DELETE http://localhost:8080/rest/api/academies/{code}
     */
    @DeleteMapping("/code/{code}")
    public Map<String, Boolean> removeAcademy(@PathVariable String code) {

        return academyService.checkRemoveAcademy(code);

    }

}
