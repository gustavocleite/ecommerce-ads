package com.sale.ecommerce.model;


import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "pessoas")
public class Pessoa extends BaseModel {
    private Integer id;
    private String nome;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
    public List<Contato> contatos() {
        return null;
    }

}
