package com.api.product_ms.controller;


import com.api.product_ms.dto.ProductDto;
import com.api.product_ms.model.Product;
import com.api.product_ms.service.ProductServive;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "Product")
public class ProductController {
    @Autowired
    ProductServive productServive;

    @PostMapping// Essa Api tou sempre retornando a dto para nao expor minha entidade
    public ResponseEntity<Optional<ProductDto>> salvar(@RequestBody @Valid ProductDto productDto){

        Optional<ProductDto> productDto1 = productServive.create(productDto);

        if (productDto1.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
        }
        return (ResponseEntity<Optional<ProductDto>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);



    }

    @GetMapping// Essa Api tou sempre retornando a dto para nao expor minha entidade
    public ResponseEntity<List<ProductDto>> Listar(){
        return ResponseEntity.status(HttpStatus.OK).body(productServive.getAll());
    }

    @GetMapping(value = "/BuscaPor{id}")
    public ResponseEntity<ProductDto>  buscarporId(@PathVariable Long id){
        Optional<ProductDto> productDto = productServive.getById(id);

        if(productDto.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(productDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


    }


}
