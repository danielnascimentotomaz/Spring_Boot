package dio.ConfigurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner {

    @Autowired
    private Remetente remetente;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: "+ remetente.getNome());
        System.out.println("Email: " + remetente.getEmail());
        System.out.println("Telefone para contatos: "+ remetente.getTelefones());
        System.out.println("Data envio: " + remetente.getData());

    }
}
