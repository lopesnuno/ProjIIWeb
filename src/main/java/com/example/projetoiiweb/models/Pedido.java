package com.example.projetoiiweb.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "data_pedido", nullable = false)
    private Instant dataPedido;

    @Column(name = "data_fim")
    private Instant dataFim;

    @ManyToMany(mappedBy = "pedidos")
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idPedido")
    private Set<Producoe> producoes = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Instant getDataFim() {
        return dataFim;
    }

    public void setDataFim(Instant dataFim) {
        this.dataFim = dataFim;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Set<Producoe> getProducoes() {
        return producoes;
    }

    public void setProducoes(Set<Producoe> producoes) {
        this.producoes = producoes;
    }

/*
    TODO [JPA Buddy] create field to map the 'estado' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "estado", columnDefinition = "estado(0, 0) not null")
    private Object estado;
*/
}