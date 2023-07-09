package com.example.projetoiiweb.models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "materias_primas")
public class MateriasPrima {
    @Id
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "nome", nullable = false, length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "qtd", nullable = false)
    private Integer qtd;

    @OneToMany(mappedBy = "idMateriaPrima")
    private Set<ProdutoMateria> produtoMaterias = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Set<ProdutoMateria> getProdutoMaterias() {
        return produtoMaterias;
    }

    public void setProdutoMaterias(Set<ProdutoMateria> produtoMaterias) {
        this.produtoMaterias = produtoMaterias;
    }

}