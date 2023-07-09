package com.example.projetoiiweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProducoeId implements Serializable {
    private static final long serialVersionUID = 4434477750337437588L;
    @Column(name = "id_pedido", nullable = false, length = Integer.MAX_VALUE)
    private String idPedido;

    @Column(name = "id_produto", nullable = false, length = Integer.MAX_VALUE)
    private String idProduto;

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
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
        ProducoeId entity = (ProducoeId) o;
        return Objects.equals(this.idProduto, entity.idProduto) &&
                Objects.equals(this.idPedido, entity.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idPedido);
    }

}