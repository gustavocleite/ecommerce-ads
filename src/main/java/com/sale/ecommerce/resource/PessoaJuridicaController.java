package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IPessoaJuridica;
import com.sale.ecommerce.model.PessoaJuridica;
import com.sale.ecommerce.service.PessoaJuridicaService;
import lombok.experimental.PackagePrivate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pessoajuridica")
public class PessoaJuridicaController implements IPessoaJuridica<PessoaJuridica,Integer> {
    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;
    @PostMapping
    @Override
    public PessoaJuridica create(@RequestBody PessoaJuridica entity) {
        return pessoaJuridicaService.create(entity);
    }
    @GetMapping
    @Override
    public List<PessoaJuridica> read() {
        return pessoaJuridicaService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    public PessoaJuridica read(@PathVariable Integer id) {
        return pessoaJuridicaService.read(id);
    }
    @PutMapping(value = "/{id}")
    @Override
    public PessoaJuridica update(@PathVariable Integer id, @RequestBody PessoaJuridica entity) {
        return pessoaJuridicaService.update(id,entity);
    }
    @DeleteMapping
    @Override
    public void delete(@RequestBody Integer id) {
        pessoaJuridicaService.delete(id);
    }
}
