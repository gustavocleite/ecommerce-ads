package com.sale.ecommerce.repository;

import com.sale.ecommerce.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
}
