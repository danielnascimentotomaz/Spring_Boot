package me.api.academia.academia_digital.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class AlunoDto {

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3,max = 50,message = "'${validatedValue}' precisa estar entre{min} e {max} caracteres")
    private String nome;

    @NotBlank(message = "Preencha o campo corretamente")
    @CPF(message = "'${validatedValue' é inválido!")
    private String cpf;

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3,max = 50,message = "'${validatedValue}' precisa estar entre{min} e {max} caracteres")
    private String bairro;

    @NotNull(message = "Prencha o campo corretamente")
    @Past(message = "Date '${validatedvalue}' é inválida")
    private LocalDate dataDeNascimento;

}
