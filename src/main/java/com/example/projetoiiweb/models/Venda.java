package com.example.projetoiiweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    private String id;
    private Timestamp data;
    private Integer iva;
    private Double total;
    private Double totalIva;
    private String estado;

    @JoinColumn(referencedColumnName = "id_cliente", nullable = false)
    private String idCliente;
}
