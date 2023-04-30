package dio.PropertiesValue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
// Com a Anotação @Value  eu crio uma configuração para meus atributos o properties
@Component
public class SistemaMensagem implements CommandLineRunner {
   @Value("${nome}")
    private  String nome;

   @Value("${email}")
    private String email;
    @Value("${telefone}")
    private List<Long> telefone;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por:");
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Seu cadrastro foi aprovado");

    }
}
