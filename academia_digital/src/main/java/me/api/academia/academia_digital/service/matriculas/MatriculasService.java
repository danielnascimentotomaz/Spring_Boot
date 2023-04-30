package me.api.academia.academia_digital.service.matriculas;

import me.api.academia.academia_digital.dto.MatriculaDto;
import me.api.academia.academia_digital.model.Aluno;
import me.api.academia.academia_digital.model.Matricula;

import java.util.List;

public interface MatriculasService {

    Aluno Create(MatriculaDto matriculaDto);

    List<Matricula> get();
}
