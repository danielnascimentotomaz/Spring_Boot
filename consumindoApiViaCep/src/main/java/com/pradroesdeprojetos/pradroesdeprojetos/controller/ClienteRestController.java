package com.pradroesdeprojetos.pradroesdeprojetos.controller;
import com.pradroesdeprojetos.pradroesdeprojetos.cliente.ConsumirApi;
import com.pradroesdeprojetos.pradroesdeprojetos.cliente.ConsumirViaCep;
import com.pradroesdeprojetos.pradroesdeprojetos.dtto.Dados;
import com.pradroesdeprojetos.pradroesdeprojetos.dtto.EnderecoFinal;
import com.pradroesdeprojetos.pradroesdeprojetos.model.Endereco;
import com.pradroesdeprojetos.pradroesdeprojetos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    ConsumirApi consumirApi;

    @Autowired ConsumirViaCep consumirViaCep;

    @Autowired
    EnderecoRepository enderecoRepository;

    // Retornando os endereço salvo no  banco de dado.
    @GetMapping()
    public List<Endereco> detalhe(){
        return enderecoRepository.findAll();
    }


    // Salvando um endereco no banco de dado.
    @PostMapping
    public ResponseEntity<Endereco> salvar(@RequestBody Dados dados){

        // usando Api via cep passando o cep vai mim retorna um endereço;
        Endereco endereco1 = consumirApi.dadosDaApi(dados.getCep());

        // Salvando o endereço no banco de dados;
        enderecoRepository.save(endereco1);

        return ResponseEntity.status(HttpStatus.CREATED).body(endereco1);

    }


    // Retornando um endereço
    @GetMapping("/ViaCP{cp}")
    public EnderecoFinal cp(@PathVariable(value = "cp") String cp){
      EnderecoFinal enderecoFinal = consumirViaCep.cep(cp);

      return enderecoFinal;



    }




}






