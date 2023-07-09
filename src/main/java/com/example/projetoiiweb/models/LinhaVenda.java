package com.example.projetoiiweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
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

    private Integer qtd;
}
