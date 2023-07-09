package com.example.projetoiiweb.services;

import com.example.projetoiiweb.models.Produto;
import com.example.projetoiiweb.repository.ProductRepository;
import com.example.projetoiiweb.services.interfaces.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceI {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Produto> findAllProdutos() {
        List<Produto> products = productRepository.findAll();

        return products.stream().map(this::mapToProduto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> findProdutoById(String id) {
        return Optional.empty();
    }

    private Produto mapToProduto(Produto product) {
        return Produto.builder()
                .id(product.getId())
                .nome(product.getNome())
                .preco(product.getPreco())
                .qtd(product.getQtd())
                .marca(product.getMarca())
                .estado(product.getEstado())
                .build();
    }
}
