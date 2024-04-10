package com.sale.ecommerce.service;

import com.sale.ecommerce.interfaces.IPessoa;
import com.sale.ecommerce.model.Pessoa;
import com.sale.ecommerce.model.PessoaFisica;
import com.sale.ecommerce.model.PessoaJuridica;
import com.sale.ecommerce.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PessoaService implements IPessoa<Pessoa,Integer> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public Pessoa create(Pessoa entity) {
        Pessoa pessoaCriada = pessoaRepository.save(entity);
        Integer idPessoa = pessoaCriada.getId();
        return pessoaRepository.save(pessoaCriada);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Pessoa> read() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa read(Integer id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if(optionalPessoa.isPresent()){
            Pessoa pessoa = optionalPessoa.get();
            return  pessoa;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Pessoa update(Integer id, Pessoa entity) {
        Pessoa pessoaEncontrada = read(id);
        pessoaEncontrada.setPessoaFisica(entity.getPessoaFisica());
        pessoaEncontrada.setPessoaJuridica(entity.getPessoaJuridica());
        pessoaEncontrada.setNome(entity.getNome());
        pessoaEncontrada.setDataFim(entity.getDataFim());
        pessoaEncontrada.setDataInicio(entity.getDataInicio());
        return pessoaEncontrada;
    }

    @Override
    public void delete(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
