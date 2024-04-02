package com.sale.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "telefones")
public class Telefone extends BaseModel{
    @Column(name = "DDD", nullable = false)
    private String ddd;
    @Column(name = "NUMERO", nullable = false)
    private String numero;
    @Column(name = "DATA_INICIO",nullable = false)
    private LocalDateTime dataInicio;
    @Column(name = "DATA_FIM", nullable = false)
    private LocalDateTime dataFim;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contato_id")
    private Contato contato;
}
