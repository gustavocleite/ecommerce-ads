package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IEmail;
import com.sale.ecommerce.model.Email;
import com.sale.ecommerce.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/email")
public class EmailController implements IEmail<Email,Integer> {
    @Autowired
    private EmailService emailService;
    @PostMapping
    @Override
    public Email create(@RequestBody Email entity) {
        return emailService.create(entity);
    }
    @GetMapping
    @Override
    public List<Email> read() {
        return emailService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    public Email read(@PathVariable Integer id) {
        return emailService.read(id);
    }
    @PutMapping(value = "/{id}")
    @Override
    public Email update(Integer id, @RequestBody Email entity) {
        return emailService.update(id,entity);
    }
    @DeleteMapping
    @Override
    public void delete(@RequestBody Integer id) {
        emailService.delete(id);
    }
}
