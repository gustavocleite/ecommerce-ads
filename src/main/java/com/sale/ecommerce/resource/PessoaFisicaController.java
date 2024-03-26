package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IPessoaFisica;
import com.sale.ecommerce.model.PessoaFisica;
import com.sale.ecommerce.service.PessoaFisicaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pessoafisica")
public class PessoaFisicaController implements IPessoaFisica<PessoaFisica,Integer> {
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    @Override
    public PessoaFisica create(@RequestBody PessoaFisica entity) {
        return pessoaFisicaService.create(entity);
    }
    @GetMapping
    @Override
    public List<PessoaFisica> read() {
        return pessoaFisicaService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    public PessoaFisica read(@PathVariable Integer id) {
        return pessoaFisicaService.read(id);
    }
    @PutMapping(value = "/{id}")
    @Override
    public PessoaFisica update(@PathVariable Integer id, @RequestBody PessoaFisica entity) {
        return pessoaFisicaService.update(id,entity);
    }
    @DeleteMapping
    @Override
    public void delete(@RequestBody Integer id) {
        pessoaFisicaService.delete(id);
    }
}
