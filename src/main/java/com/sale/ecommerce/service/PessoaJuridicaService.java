package com.sale.ecommerce.service;

import com.sale.ecommerce.interfaces.IPessoaJuridica;
import com.sale.ecommerce.model.PessoaFisica;
import com.sale.ecommerce.model.PessoaJuridica;
import com.sale.ecommerce.repository.PessoaJuridicaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PessoaJuridicaService implements IPessoaJuridica<PessoaJuridica,Integer> {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;
    @Override
    public PessoaJuridica create(PessoaJuridica entity) {
        return pessoaJuridicaRepository.save(entity);
    }

    @Override
    public List<PessoaJuridica> read() {
        return pessoaJuridicaRepository.findAll();
    }

    @Override
    public PessoaJuridica read(Integer id) {
        Optional<PessoaJuridica> optionalPessoaJuridica = pessoaJuridicaRepository.findById(id);
        if(optionalPessoaJuridica.isPresent()){
            PessoaJuridica pessoaJuridica = optionalPessoaJuridica.get();
            return  pessoaJuridica;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public PessoaJuridica update(Integer id, PessoaJuridica entity) {
        PessoaJuridica pessoaJuridicaEncontrada = read(id);
        pessoaJuridicaEncontrada.setCnpj(entity.getCnpj());
        return pessoaJuridicaEncontrada;
    }

    @Override
    public void delete(Integer id) {
        pessoaJuridicaRepository.deleteById(id);
    }
}
