package com.example.projetoiiweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nome;
    private Integer tel;
    private Integer nif;
    private String estado;
    private String username;
    private String password;

    @OneToMany(mappedBy = "cliente")
    private Set<Venda> vendas = new LinkedHashSet<>();
}
