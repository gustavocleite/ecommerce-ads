package com.sale.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "telefone")
public class Telefone extends BaseModel{
    private String ddd;
    private String numero;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Contato contato;
}
