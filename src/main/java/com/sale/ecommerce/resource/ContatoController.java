package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IContato;
import com.sale.ecommerce.model.Contato;
import com.sale.ecommerce.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/contato")
public class ContatoController implements IContato<Contato,Integer> {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @Override
    public Contato create(@RequestBody Contato entity) {
        return contatoService.create(entity);
    }

    @GetMapping
    @Override
    public List<Contato> read() {
        return contatoService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    public Contato read(@PathVariable Integer id) {
        return contatoService.read(id);
    }
    @PutMapping(value = "/{id}")
    @Override
    public Contato update(@PathVariable Integer id, @RequestBody Contato entity) {
        return contatoService.update(id,entity);
    }

    @Override
    public void delete(@RequestBody Integer id) {
        contatoService.delete(id);
    }
}
