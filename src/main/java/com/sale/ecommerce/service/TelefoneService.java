package com.sale.ecommerce.service;

import com.sale.ecommerce.interfaces.ITelefone;
import com.sale.ecommerce.model.Pessoa;
import com.sale.ecommerce.model.Telefone;
import com.sale.ecommerce.repository.TelefoneRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TelefoneService implements ITelefone<Telefone,Integer> {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public Telefone create(Telefone entity) {
        return telefoneRepository.save(entity);
    }

    @Override
    public List<Telefone> read() {
        return telefoneRepository.findAll();
    }

    @Override
    public Telefone read(Integer id) {
        Optional<Telefone> optionalTelefone = telefoneRepository.findById(id);
        if(optionalTelefone.isPresent()){
            Telefone telefone = optionalTelefone.get();
            return  telefone;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Telefone update(Integer id, Telefone entity) {
        Telefone telefoneEncontrado = read(id);
        telefoneEncontrado.setContato(entity.getContato());
        telefoneEncontrado.setDdd(entity.getDdd());
        telefoneEncontrado.setNumero(entity.getNumero());
        telefoneEncontrado.setDataFim(entity.getDataFim());
        telefoneEncontrado.setDataInicio(entity.getDataInicio());
        return telefoneRepository.save(telefoneEncontrado);
    }

    @Override
    public void delete(Integer id) {
        telefoneRepository.deleteById(id);
    }
}
