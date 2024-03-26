package com.sale.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "pessoa")
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
