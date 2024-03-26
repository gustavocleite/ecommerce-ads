package com.sale.ecommerce.service;

import com.sale.ecommerce.interfaces.IEmail;
import com.sale.ecommerce.model.Email;
import com.sale.ecommerce.repository.EmailRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class EmailService implements IEmail<Email,Integer> {
    @Autowired
    private EmailRepository emailRepository;
    @Override
    public Email create(Email entity) {
        return emailRepository.save(entity);
    }

    @Override
    public List<Email> read() {
        return emailRepository.findAll();
    }

    @Override
    public Email read(Integer id) {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        if(optionalEmail.isPresent()){
            Email emailEncontrado = optionalEmail.get();
            return  emailEncontrado;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Email update(Integer id, Email entity) {
        Email emailUpdate = read(id);
        emailUpdate.setEnderecoEmail(entity.getEnderecoEmail());
        emailUpdate.setContato(entity.getContato());
        emailUpdate.setDataFim(entity.getDataFim());
        emailUpdate.setDataInicio(entity.getDataInicio());
        return emailRepository.save(emailUpdate);
    }

    @Override
    public void delete(Integer id) {
        emailRepository.deleteById(id);
    }
}
