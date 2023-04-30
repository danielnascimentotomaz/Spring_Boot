package me.api.academia.academia_digital.controller;

import jakarta.validation.Valid;
import me.api.academia.academia_digital.dto.MatriculaDto;
import me.api.academia.academia_digital.model.Aluno;
import me.api.academia.academia_digital.model.Matricula;
import me.api.academia.academia_digital.service.matriculas.MatriculasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Matriculas")
public class MatriculaController {
    @Autowired
    MatriculasServices matriculasServices;

    @GetMapping
    public List<Matricula> get(){
        return matriculasServices.get();
    }

    @PostMapping
    public Aluno create( MatriculaDto matriculaDto){
        return matriculasServices.Create(matriculaDto);


    }
}
