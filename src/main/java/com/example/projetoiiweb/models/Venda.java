package com.example.projetoiiweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    private String id;
    private Timestamp data;
    private Integer iva;
    private Double total;
    private Double totalIva;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(
            name = "linha_venda",
            joinColumns = { @JoinColumn(name = "id_venda") },
            inverseJoinColumns = { @JoinColumn(name = "id_produto") }
    )
    private Set<Produto> produtos = new HashSet<Produto>();
}
