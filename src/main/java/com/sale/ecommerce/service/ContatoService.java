package com.sale.ecommerce.service;

import com.sale.ecommerce.interfaces.IContato;
import com.sale.ecommerce.model.Contato;
import com.sale.ecommerce.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContatoService implements IContato<Contato,Integer> {
    @Autowired
    private ContatoRepository contatoRepository;
    @Override
    public Contato create(Contato entity) {
        return contatoRepository.save(entity);
    }

    @Override
    public List<Contato> read() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato read(Integer id) {
        Optional<Contato> optContato = contatoRepository.findById(id);
        if(optContato.isPresent()) {
            Contato contatoEncontrado = optContato.get();
        return contatoEncontrado;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Contato update(Integer id, Contato entity) {
        Contato contatoEncontrado = read(id);
        contatoEncontrado.setDataFim(entity.getDataFim());
        contatoEncontrado.setEmails(entity.getEmails());
        contatoEncontrado.setPessoa(entity.getPessoa());
        contatoEncontrado.setEnderecos(entity.getEnderecos());
        contatoEncontrado.setDataInicio(entity.getDataInicio());
        contatoEncontrado.setTelefones(entity.getTelefones());
        return contatoRepository.save(contatoEncontrado);
    }

    @Override
    public void delete(Integer id) {
        contatoRepository.deleteById(id);
    }
}
