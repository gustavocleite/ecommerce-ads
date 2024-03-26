package com.sale.ecommerce.repository;

import com.sale.ecommerce.model.PessoaJuridica;
import com.sale.ecommerce.service.PessoaJuridicaService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica,Integer> {
}
