package com.example.projetoiiweb.services.interfaces;

import com.example.projetoiiweb.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProductServiceI {
    List<Produto> findAllProdutos();
    Optional<Produto> findProdutoById(String id);
}
