package com.sale.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "contatos")
public class Contato extends BaseModel{
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Pessoa pessoa;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

}
