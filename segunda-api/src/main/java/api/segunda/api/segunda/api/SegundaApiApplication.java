package api.segunda.api.segunda.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cadrastramento de usuario", version = "1.0", description = "Cadrastramento de usuario usando lista"))
public class SegundaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegundaApiApplication.class, args);
	}

}
