package com.produtos.ApiRest.repository;

import com.produtos.ApiRest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
