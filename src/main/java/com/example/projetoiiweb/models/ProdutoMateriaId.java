package com.example.projetoiiweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoMateriaId implements Serializable {
    private static final long serialVersionUID = -9070038941295388256L;
    @Column(name = "id_produto", nullable = false, length = Integer.MAX_VALUE)
    private String idProduto;

    @Column(name = "id_materia_prima", nullable = false, length = Integer.MAX_VALUE)
    private String idMateriaPrima;

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(String idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProdutoMateriaId entity = (ProdutoMateriaId) o;
        return Objects.equals(this.idProduto, entity.idProduto) &&
                Objects.equals(this.idMateriaPrima, entity.idMateriaPrima);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idMateriaPrima);
    }

}