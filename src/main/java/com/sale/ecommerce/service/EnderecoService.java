package com.sale.ecommerce.service;

import com.sale.ecommerce.interfaces.IEndereco;

import com.sale.ecommerce.model.Endereco;
import com.sale.ecommerce.repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class EnderecoService implements IEndereco<Endereco, Integer> {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Override
    public Endereco create(Endereco entity) {
        return enderecoRepository.save(entity);
    }

    @Override
    public List<Endereco> read() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco read(Integer id) {
        Optional<Endereco> optEMail = enderecoRepository.findById(id);
        if(optEMail.isPresent()){
            Endereco enderecoEncontrado = optEMail.get();
            return  enderecoEncontrado;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Endereco update(Integer id, Endereco entity) {
        Endereco enderecoEncontrado = read(id);
        enderecoEncontrado.setContato(entity.getContato());
        enderecoEncontrado.setLogradouro(entity.getLogradouro());
        enderecoEncontrado.setDataFim(entity.getDataFim());
        enderecoEncontrado.setDataInicio(entity.getDataInicio());
        return enderecoRepository.save(enderecoEncontrado);
    }

    @Override
    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
