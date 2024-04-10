package com.sale.ecommerce.model;


import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "pessoas")
public class Pessoa extends BaseModel {
    @Column( name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "DATA_INICIO",nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM", nullable = false)
    private LocalDateTime dataFim;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private PessoaJuridica pessoaJuridica;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private PessoaFisica pessoaFisica;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    public  List<Contato> contatos ;
}
