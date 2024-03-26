package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IEndereco;
import com.sale.ecommerce.model.Endereco;
import com.sale.ecommerce.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController implements IEndereco<Endereco,Integer> {
    @Autowired
    private EnderecoService enderecoService;
    @PostMapping
    @Override
    public Endereco create(@RequestBody Endereco entity) {
        return enderecoService.create(entity);
    }
    @GetMapping
    @Override
    public List<Endereco> read() {
        return enderecoService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    public Endereco read(@PathVariable Integer id) {
        return enderecoService.read(id);
    }
    @PutMapping(value = "/{id}")
    @Override
    public Endereco update(@PathVariable Integer id, @RequestBody Endereco entity) {
        return enderecoService.update(id,entity);
    }
    @DeleteMapping
    @Override
    public void delete(@RequestBody Integer id) {
        enderecoService.delete(id);
    }
}
