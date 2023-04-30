package me.api.academia.academia_digital.service.aluno;

import me.api.academia.academia_digital.dto.AlunoDto;
import me.api.academia.academia_digital.model.Aluno;
import me.api.academia.academia_digital.model.AvaliacaoFisica;

import java.util.List;
import java.util.Optional;

public interface AlunoServices {
    List<Aluno> getAll();

    Aluno Create(AlunoDto alunoDto);



    List<AvaliacaoFisica> get(Long id);
}
