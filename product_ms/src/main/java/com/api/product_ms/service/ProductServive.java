package com.api.product_ms.service;

import com.api.product_ms.dto.ProductDto;
import com.api.product_ms.model.Product;
import com.api.product_ms.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBeanAttributeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServive implements ProductService{

    @Autowired
    ModelMapper mapper; // Para não precisar toda hora que eu chama o método instaciar um objeto
    //da classe ModelMapper.

    @Autowired
    ProductRepository productRepository;
    @Override
    public Optional<ProductDto> create(ProductDto productDto) {

        // Criando um objeto do tipo ProductModel para salva no banco de dado
        Product product = new Product();

        // Adicionando os valores manualmente  ou eu tambem podia usar a dependência ModelMapper para converter de dto para model

       // ModelMapper modelMapper = new ModelMapper();
       // modelMapper.map(productDto,product);

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setAvailable(productDto.isAvailable());

        productRepository.saveAndFlush(product);
        return Optional.of(productDto);


    }

    @Override
    public List<ProductDto> getAll() {

        List<Product> ListaProdutos = productRepository.findAll(); // productRepository.findAll() mim retorna a lista de produtos
        // adicionando essa lista na lista a ListaProdutos;

        List<ProductDto> ListaProductDtos = new ArrayList<>();

        for(Product x: ListaProdutos){// Percorrendo a lista de produtos

            ProductDto productDto = new ProductDto();


            mapper.map(x,productDto);// fazendo o mapeamento de produto para dto

            ListaProductDtos.add(productDto);// adicionado produtodto na listaproductdto

        }

        return ListaProductDtos;// retonando a listaproductdto

    }

    @Override
    public Optional<ProductDto> getById(Long id) {
        ProductDto productDto = new ProductDto();

        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            mapper.map(product,productDto);
            return Optional.of(productDto);

        }

        return Optional.empty(); // se não encontra id retorna um vazio

    }

    @Override
    public boolean inactive(Long id) {
        Optional<Product> product = productRepository.findById(id);// buscando um produto

        // verificando se o produto existe
        if(product.isPresent()){
            product.get().setAvailable(false);
            return  true;
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.delete(product.get());
        }

    }
}
