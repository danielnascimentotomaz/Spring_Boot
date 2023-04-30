package me.api.academia.academia_digital.service.matriculas;

import me.api.academia.academia_digital.dto.MatriculaDto;
import me.api.academia.academia_digital.model.Aluno;
import me.api.academia.academia_digital.model.Matricula;
import me.api.academia.academia_digital.repository.AlunoRepository;
import me.api.academia.academia_digital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculasServices implements MatriculasService{
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    MatriculaRepository matriculaRepository;

    @Override
    public Aluno Create(MatriculaDto matriculaDto) {
        Matricula matricula = new Matricula();

        Aluno aluno = alunoRepository.findById(matriculaDto.getIdDoAluno()).get();

        matricula.setAluno(aluno);
        matriculaRepository.save(matricula);
        return aluno;

    }

    @Override
    public List<Matricula> get() {
        return matriculaRepository.findAll();
    }
}
