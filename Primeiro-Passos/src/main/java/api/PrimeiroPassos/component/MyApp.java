package api.PrimeiroPassos.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApp implements CommandLineRunner {
    @Autowired
    private Calculadora calculadora; //Quando estou trabalhando com projeto spring eu nao posso mais da
    // new para criar nossos projeto tenho que usar injeção de dependência

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Resultado:");

        System.out.println(calculadora.somar(2,5));

    }
}
