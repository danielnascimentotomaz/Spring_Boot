package com.produtos.apiprodutos.controller;

import com.produtos.apiprodutos.handler.BusinessException;
import com.produtos.apiprodutos.models.ProdutosModels;
import com.produtos.apiprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/listaProdutos")
    public List<ProdutosModels> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/{id}" )
    public Optional<ProdutosModels> produtoId(@PathVariable(value = "id") Long id){
        return produtoRepository.findById(id);


    }

    @PostMapping("/produto")
    public ProdutosModels salvarProduto(@RequestBody ProdutosModels produtosModels){
       if(produtosModels.getNome() == null)
           throw new BusinessException("O campo nome é  obrigatorio");

        return produtoRepository.save(produtosModels);
    }

    @DeleteMapping("/deletar")

    public void deletarProduto(@RequestBody ProdutosModels produtosModels){
        produtoRepository.delete(produtosModels);
        System.out.println("produto deletado");
    }
    @PutMapping("/atualizar")
    public ProdutosModels atualizarProdut(@RequestBody ProdutosModels produtosModels){
        return produtoRepository.save(produtosModels);
    }






}
