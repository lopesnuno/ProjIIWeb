package com.example.projetoiiweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "linha_venda")
public class LinhaVenda {
    @EmbeddedId
    private LinhaVendaId id;

    @Column(name = "qtd", nullable = false)
    private Integer qtd;

    public LinhaVendaId getId() {
        return id;
    }

    public void setId(LinhaVendaId id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

}