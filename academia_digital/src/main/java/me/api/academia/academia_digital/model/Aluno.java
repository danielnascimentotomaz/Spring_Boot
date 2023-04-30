package me.api.academia.academia_digital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) //Para ignorar a exceções do  FetchType.LAZY
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "cpf",unique = true)
    private String cpf;
    @Column(name = "bairro",nullable = false )
    private String bairro;
    @Column(name = "dataDeNascimento")
    private LocalDate dataDeNascimento;

    @OneToMany(mappedBy = "aluno",fetch = FetchType.LAZY)// fetch = FetchType.LAZY Quando eu pedir para mostra o aluno não vai mostra lista de avalições
    @JsonIgnore                                          //   @OneToMany Um aluno pode ter varias avaliações
    //Para ignorar a exceções do  FetchType.LAZY

    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
}
