package me.api.academia.academia_digital.service.avaliacao;

import me.api.academia.academia_digital.dto.AvaliacaoDto;
import me.api.academia.academia_digital.model.AvaliacaoFisica;

public interface AvaliacaoServices {

    AvaliacaoFisica create(AvaliacaoDto avaliacaoDto);
}
