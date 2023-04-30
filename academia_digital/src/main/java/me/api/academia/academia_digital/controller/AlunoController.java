package me.api.academia.academia_digital.controller;

import jakarta.validation.Valid;
import me.api.academia.academia_digital.dto.AlunoDto;
import me.api.academia.academia_digital.model.Aluno;
import me.api.academia.academia_digital.model.AvaliacaoFisica;
import me.api.academia.academia_digital.service.aluno.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "Sistema de Academia")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @GetMapping(value= "/Aluno")
    public List<Aluno> dados(){
        return alunoService.getAll();

    }

    @GetMapping(value = "/Avaliacões/{id}")
    public List<AvaliacaoFisica> get(@PathVariable Long id){
        return alunoService.get(id);
    }

    @PostMapping(value = "Aluno")
    public Aluno create(@Valid @RequestBody AlunoDto alunoDto){
       return alunoService.Create(alunoDto);
    }


}
