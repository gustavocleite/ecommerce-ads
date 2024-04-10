package com.sale.ecommerce.repository;

import com.sale.ecommerce.model.Pessoa;
import com.sale.ecommerce.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
    @Modifying
    @Query("UPDATE Pessoa p SET p.pessoaFisica.id = :pessoaFisica WHERE p.id = :pessoaId")
    void associarPessoaFisicaAoId(long pessoaId, Integer pessoaFisicaID);
}
