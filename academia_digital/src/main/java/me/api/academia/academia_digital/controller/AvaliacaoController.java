package me.api.academia.academia_digital.controller;

import jakarta.validation.Valid;
import me.api.academia.academia_digital.dto.AvaliacaoDto;
import me.api.academia.academia_digital.model.AvaliacaoFisica;
import me.api.academia.academia_digital.service.avaliacao.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "AvaliaçãoFisica")
public class AvaliacaoController {

    @Autowired
    AvaliacaoService avaliacaoService;

    @PostMapping
    public AvaliacaoFisica create(@Valid AvaliacaoDto avaliacaoDto){
         return avaliacaoService.create(avaliacaoDto);
    }



}
