package br.com.Spring_Boot_04.controllers;

import br.com.Spring_Boot_04.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private  static final String modeloMensagem="Olá, %s!";
    private  final  AtomicLong counter= new AtomicLong();

    //http://localhost:8080/greeting?name=veloso
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "no aguardo")
            String name){
        return new Greeting(counter.incrementAndGet(),String.format(modeloMensagem,name));

    }
}
