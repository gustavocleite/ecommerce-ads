package com.sale.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "email")
public class Email extends  BaseModel{
    private String enderecoEmail;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Contato contato;
}
