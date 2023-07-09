package com.example.projetoiiweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaPedidoId implements Serializable {
    private static final long serialVersionUID = -3503285797921339917L;
    @Column(name = "id_funcionario", nullable = false, length = Integer.MAX_VALUE)
    private String idFuncionario;

    @Column(name = "id_pedido", nullable = false, length = Integer.MAX_VALUE)
    private String idPedido;

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinhaPedidoId entity = (LinhaPedidoId) o;
        return Objects.equals(this.idFuncionario, entity.idFuncionario) &&
                Objects.equals(this.idPedido, entity.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncionario, idPedido);
    }

}