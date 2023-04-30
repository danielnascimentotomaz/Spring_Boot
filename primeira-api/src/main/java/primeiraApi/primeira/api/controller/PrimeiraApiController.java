package primeiraApi.primeira.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apresentacao")
public class PrimeiraApiController {

    @GetMapping(value = "/frase")
    public String getfrase(){
        return "Ela era interessante. Um olhar enigmático, um jeito cativante que dizia muito," +
                " mas poucos a entendiam. Seu sorriso era versado, um verdadeiro soneto ecoava na" +
                " doçura de sua expressão. Ela era um poema completo, e como todo poema, era incompreendida " +
                "por muitos, e apreciada por quem a sentia no meio de tanta confusão.";
    }

    @GetMapping(value = "/autor")
    public Pessoa getAutor(){
        Pessoa autor = new Pessoa();
        autor.mome = "daniel nascimento tomaz";
        autor.idade = 27;
        return autor;

    }


}

class Pessoa{
    public String mome;
    public int idade;
}

