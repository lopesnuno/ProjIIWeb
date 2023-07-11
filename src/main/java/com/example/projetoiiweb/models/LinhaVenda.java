package com.example.projetoiiweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "linha_venda")
public class LinhaVenda {
    @Id
    @JoinColumn(referencedColumnName = "id_venda")
    private String idVenda;

    @Id
    @JoinColumn(referencedColumnName = "id_produto")
    private String idProduto;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda idVenda1;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto1;

    private Integer qtd;
}
