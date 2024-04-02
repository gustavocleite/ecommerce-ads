package com.sale.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private List<Email> emails = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private List<Endereco> enderecos = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private List<Telefone> telefones = new ArrayList<>();

}
