package com.sale.ecommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "pessoaJuridica")
public class PessoaJuridica extends BaseModel {
    private String cnpj;
}
