package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IPessoaFisica;
import com.sale.ecommerce.model.PessoaFisica;
import com.sale.ecommerce.service.PessoaFisicaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pessoafisica")
public class PessoaFisicaController implements IPessoaFisica<PessoaFisica,Integer> {
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public PessoaFisica create(@Valid @RequestBody PessoaFisica entity) {
        return pessoaFisicaService.create(entity);
    }
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public List<PessoaFisica> read() {
        return pessoaFisicaService.read();
    }
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public PessoaFisica read(@PathVariable Integer id) {
        return pessoaFisicaService.read(id);
    }
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public PessoaFisica update(@PathVariable Integer id,@Valid @RequestBody PessoaFisica entity) {
        return pessoaFisicaService.update(id,entity);
    }
    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        pessoaFisicaService.delete(id);
    }
}
