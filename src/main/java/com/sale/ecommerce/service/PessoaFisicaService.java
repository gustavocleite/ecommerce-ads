package com.sale.ecommerce.service;

import com.sale.ecommerce.interfaces.IPessoaFisica;
import com.sale.ecommerce.model.Endereco;
import com.sale.ecommerce.model.PessoaFisica;
import com.sale.ecommerce.repository.PessoaFisicaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PessoaFisicaService implements IPessoaFisica<PessoaFisica,Integer> {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;
    @Override
    public PessoaFisica create(PessoaFisica entity) {
        return pessoaFisicaRepository.save(entity);
    }

    @Override
    public List<PessoaFisica> read() {
        return pessoaFisicaRepository.findAll();
    }

    @Override
    public PessoaFisica read(Integer id) {
        Optional<PessoaFisica> optionalPessoaFisica = pessoaFisicaRepository.findById(id);
        if(optionalPessoaFisica.isPresent()){
            PessoaFisica pessoaFisica = optionalPessoaFisica.get();
            return  pessoaFisica;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public PessoaFisica update(Integer id, PessoaFisica entity) {
        PessoaFisica pessoaEncontrada = read(id);
        pessoaEncontrada.setCpf(entity.getCpf());
        return pessoaFisicaRepository.save(pessoaEncontrada);
    }

    @Override
    public void delete(Integer id) {
        pessoaFisicaRepository.deleteById(id);
    }
}
