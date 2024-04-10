package com.sale.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Data
@Entity
@Table(name = "contatos")

public class Contato extends BaseModel{
    @Column(name = "DATA_INICIO",nullable = false)
    private LocalDateTime dataInicio;
    @Column(name = "DATA_FIM", nullable = false)
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, orphanRemoval = true,  fetch = FetchType.LAZY)
    private List<Email> emails = new ArrayList<>();

    @OneToMany(mappedBy = "contato",cascade = CascadeType.ALL, orphanRemoval = true,  fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();;

    @OneToMany(mappedBy = "contato",cascade = CascadeType.ALL, orphanRemoval = true,  fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();;

}
