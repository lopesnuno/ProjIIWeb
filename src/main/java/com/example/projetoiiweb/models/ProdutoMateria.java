package com.example.projetoiiweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto_materia")
public class ProdutoMateria {
    @EmbeddedId
    private ProdutoMateriaId id;

    @Column(name = "qtd", nullable = false)
    private Integer qtd;

    public ProdutoMateriaId getId() {
        return id;
    }

    public void setId(ProdutoMateriaId id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

}