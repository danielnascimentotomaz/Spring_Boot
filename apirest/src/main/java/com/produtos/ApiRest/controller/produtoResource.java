package com.produtos.ApiRest.controller;

import com.produtos.ApiRest.models.Produto;
import com.produtos.ApiRest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class produtoResource {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public List<Produto> listaProduto(){
        return  produtoRepository.findAll();// findAll mim retorna a lista de produtos cadrastada no banco de dado

    }


    @PostMapping("/produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }



    @PutMapping("/AtualizarPor{id}")
    public ResponseEntity<Object> atualizaProduto(@PathVariable(value = "id") Long id, @RequestBody Produto produto){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if(!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");

        }
        // produto  que retornado pelo id
        Produto produto1 = produtoOptional.get();

    

        // atualizando o produto  que retornado pelo id
        produto1.setNome(produto.getNome());
        produto1.setQuantidade(produto.getQuantidade());
        produto1.setValor(produto.getValor());

        produtoRepository.save(produto1);

        return ResponseEntity.status(HttpStatus.OK).body(produto1);

    }


    @DeleteMapping("/DeletarPor{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value = "id") Long id){

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if(!produtoOptional.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");

        }

        produtoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional);

    }





}
