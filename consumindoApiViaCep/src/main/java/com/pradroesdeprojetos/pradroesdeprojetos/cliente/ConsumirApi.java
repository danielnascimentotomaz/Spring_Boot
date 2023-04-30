package com.pradroesdeprojetos.pradroesdeprojetos.cliente;

import com.pradroesdeprojetos.pradroesdeprojetos.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep",url = "https://viacep.com.br/ws/")
public interface ConsumirApi {
    @GetMapping(value = "{cep}/json/")
    Endereco dadosDaApi(@PathVariable(value = "cep") String cep);
    
}
