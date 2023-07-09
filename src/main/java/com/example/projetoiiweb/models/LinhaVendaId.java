package com.example.projetoiiweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaVendaId implements Serializable {
    private static final long serialVersionUID = 5051470535460239418L;
    @Column(name = "id_venda", nullable = false, length = Integer.MAX_VALUE)
    private String idVenda;

    @Column(name = "id_produto", nullable = false, length = Integer.MAX_VALUE)
    private String idProduto;

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinhaVendaId entity = (LinhaVendaId) o;
        return Objects.equals(this.idProduto, entity.idProduto) &&
                Objects.equals(this.idVenda, entity.idVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idVenda);
    }

}