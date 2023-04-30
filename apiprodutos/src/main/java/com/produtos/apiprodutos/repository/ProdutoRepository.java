package com.produtos.apiprodutos.repository;

import com.produtos.apiprodutos.models.ProdutosModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutosModels,Long> {




}
