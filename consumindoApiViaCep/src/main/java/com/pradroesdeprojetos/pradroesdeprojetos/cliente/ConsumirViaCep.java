package com.pradroesdeprojetos.pradroesdeprojetos.cliente;

import com.pradroesdeprojetos.pradroesdeprojetos.dtto.EnderecoFinal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCEP",url = "https://viacep.com.br/ws/")
public interface ConsumirViaCep {
    @GetMapping(value = "{cep}/json/")
    EnderecoFinal cep(@PathVariable(value = "cep") String cep);

}
