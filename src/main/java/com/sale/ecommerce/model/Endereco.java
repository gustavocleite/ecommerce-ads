package com.sale.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "enderecos")
public class Endereco extends BaseModel{
    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "DATA_INICIO",nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM", nullable = false)
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contato_id")
    private Contato contato;
}
