package com.example.projetoiiweb.repository;

import com.example.projetoiiweb.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Cliente, String> {

}
