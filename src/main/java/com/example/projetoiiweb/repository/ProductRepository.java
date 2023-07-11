package com.example.projetoiiweb.repository;

import com.example.projetoiiweb.models.Cliente;
import com.example.projetoiiweb.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Produto, String> {}
