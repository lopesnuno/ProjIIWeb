package com.example.projetoiiweb.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "nome", nullable = false, length = Integer.MAX_VALUE)
    private String nome;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "qtd", nullable = false)
    private Integer qtd;

    @Column(name = "marca", length = Integer.MAX_VALUE)
    private String marca;

    @Column(name = "estado", nullable = false, length = Integer.MAX_VALUE)
    private String estado;

    @OneToMany(mappedBy = "idProduto")
    private Set<LinhaVenda> linhaVendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProduto")
    private Set<Producoe> producoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProduto")
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<LinhaVenda> getLinhaVendas() {
        return linhaVendas;
    }

    public void setLinhaVendas(Set<LinhaVenda> linhaVendas) {
        this.linhaVendas = linhaVendas;
    }

    public Set<Producoe> getProducoes() {
        return producoes;
    }

    public void setProducoes(Set<Producoe> producoes) {
        this.producoes = producoes;
    }

    public Set<ProdutoMateria> getProdutoMaterias() {
        return produtoMaterias;
    }

    public void setProdutoMaterias(Set<ProdutoMateria> produtoMaterias) {
        this.produtoMaterias = produtoMaterias;
    }

}