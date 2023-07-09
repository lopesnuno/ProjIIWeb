package com.example.projetoiiweb.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "data", nullable = false)
    private Instant data;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @Column(name = "iva", nullable = false)
    private Integer iva;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "total_iva")
    private Double totalIva;

    @OneToMany(mappedBy = "idVenda")
    private Set<LinhaVenda> linhaVendas = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
    }

    public Set<LinhaVenda> getLinhaVendas() {
        return linhaVendas;
    }

    public void setLinhaVendas(Set<LinhaVenda> linhaVendas) {
        this.linhaVendas = linhaVendas;
    }

/*
    TODO [JPA Buddy] create field to map the 'estado' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "estado", columnDefinition = "estado(0, 0)")
    private Object estado;
*/
}