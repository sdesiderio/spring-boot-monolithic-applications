package com.sistemi.controller;

import com.sistemi.bean.MessageBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
L'annotation @RestController
abilita la classe DemoController
ad esporsi sotto forma di Restful
Web Service Provider (ovvero è
possibile mappare ogni singolo
metodo della classe con una
annotation che rappresenta un
verbo HTTP REST
 */
@RestController
@RequestMapping("/demo-service")
public class DemoController {

    /*
    Per consumare questa operazione
    il Consumer dovrà eseguire la
    seguente richiesta:
    http://localhost:9090/welcome
     */
    @GetMapping("/welcome")
    public MessageBean getMessage(){

        /*
        Dietro le quinte viene eseguito
        un processo che si chiama Jackson
        Object Mapper il quale è un listener,
        sta in ascolto sull'esecuzione dei metodi
        di un @RestController e,nel caso in cui i
        metodi restituiscano un Oggetto Java, converte
        l'Oggetto in un JSON
         */
        return new MessageBean("welcome");
    }
}
