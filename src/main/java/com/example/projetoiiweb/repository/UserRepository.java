package com.example.projetoiiweb.repository;

import com.example.projetoiiweb.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findUserByUsername(String username);
}
