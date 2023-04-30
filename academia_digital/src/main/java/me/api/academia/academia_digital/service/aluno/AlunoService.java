package me.api.academia.academia_digital.service.aluno;

import me.api.academia.academia_digital.dto.AlunoDto;
import me.api.academia.academia_digital.model.Aluno;
import me.api.academia.academia_digital.model.AvaliacaoFisica;
import me.api.academia.academia_digital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService implements AlunoServices {
    @Autowired
    AlunoRepository alunoRepository;
    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno Create(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDto.getNome());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setBairro(alunoDto.getBairro());
        aluno.setDataDeNascimento(alunoDto.getDataDeNascimento());
        return alunoRepository.save(aluno);



    }

    @Override
    public List<AvaliacaoFisica> get(Long id) {
       Aluno aluno = alunoRepository.findById(id).get();
       return aluno.getAvaliacoes();

    }


}
