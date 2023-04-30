package me.api.academia.academia_digital.service.avaliacao;

import me.api.academia.academia_digital.dto.AvaliacaoDto;
import me.api.academia.academia_digital.model.Aluno;
import me.api.academia.academia_digital.model.AvaliacaoFisica;
import me.api.academia.academia_digital.repository.AlunoRepository;
import me.api.academia.academia_digital.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService implements AvaliacaoServices{
    @Autowired
    AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    AlunoRepository alunoRepository;
    @Override
    public AvaliacaoFisica create(AvaliacaoDto avaliacaoDto) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        Aluno aluno = alunoRepository.findById(avaliacaoDto.getIdDoAluno()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(avaliacaoDto.getPeso());
        avaliacaoFisica.setAltura(avaliacaoDto.getAltura());

        avaliacaoFisicaRepository.save(avaliacaoFisica);

        return avaliacaoFisica;
    }
}
