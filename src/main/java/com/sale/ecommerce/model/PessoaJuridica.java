package com.sale.ecommerce.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "pessoaJuridica")
public class PessoaJuridica extends BaseModel {
    @Column(name = "CNPJ", length = 14,nullable = false)
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;
}
