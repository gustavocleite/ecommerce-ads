package com.sale.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "pessoaFisica")
public class PessoaFisica extends BaseModel{
    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;
}
