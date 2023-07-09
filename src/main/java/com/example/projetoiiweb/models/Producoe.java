package com.example.projetoiiweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "producoes")
public class Producoe {
    @EmbeddedId
    private ProducoeId id;

    @Column(name = "qtd", nullable = false)
    private Integer qtd;

    @Column(name = "data", nullable = false)
    private Instant data;

    public ProducoeId getId() {
        return id;
    }

    public void setId(ProducoeId id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

/*
    TODO [JPA Buddy] create field to map the 'estado' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "estado", columnDefinition = "estado(0, 0) not null")
    private Object estado;
*/
}