package com.example.projetoiiweb.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "linha_pedidos")
public class LinhaPedido {
    @EmbeddedId
    private LinhaPedidoId id;

    public LinhaPedidoId getId() {
        return id;
    }

    public void setId(LinhaPedidoId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}