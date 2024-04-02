package com.sale.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "emails")
public class Email extends  BaseModel{
    @Column(name = "ENDERECO_EMAIL", nullable = false)
    private String enderecoEmail;
    @Column(name = "DATA_INICIO",nullable = false)
    private LocalDateTime dataInicio;
    @Column(name = "DATA_FIM", nullable = false)
    private LocalDateTime dataFim;
    private Contato contato;
}
