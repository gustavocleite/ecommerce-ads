package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IEndereco;
import com.sale.ecommerce.interfaces.IPessoa;
import com.sale.ecommerce.model.Pessoa;
import com.sale.ecommerce.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pessoa")
public class PessoaController implements IPessoa<Pessoa,Integer> {
    @Autowired
    private PessoaService pessoaService;
    @PostMapping
    @Override
    public Pessoa create(@RequestBody Pessoa entity) {
        return pessoaService.create(entity);
    }
    @GetMapping
    @Override
    public List<Pessoa> read() {
        return pessoaService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    public Pessoa read(Integer id) {
        return pessoaService.read(id);
    }
    @PutMapping("/{id}")
    @Override
    public Pessoa update(@PathVariable Integer id,@RequestBody Pessoa entity) {
        return pessoaService.update(id,entity);
    }
    @DeleteMapping
    @Override
    public void delete(@RequestBody Integer id) {
        pessoaService.delete(id);
    }
}
