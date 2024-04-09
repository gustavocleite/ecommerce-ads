package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IPessoaJuridica;
import com.sale.ecommerce.model.PessoaJuridica;
import com.sale.ecommerce.service.PessoaJuridicaService;
import jakarta.validation.Valid;
import lombok.experimental.PackagePrivate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pessoajuridica")
public class PessoaJuridicaController implements IPessoaJuridica<PessoaJuridica,Integer> {
    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public PessoaJuridica create(@Valid @RequestBody PessoaJuridica entity) {
        return pessoaJuridicaService.create(entity);
    }
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public List<PessoaJuridica> read() {
        return pessoaJuridicaService.read();
    }
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public PessoaJuridica read(@PathVariable Integer id) {
        return pessoaJuridicaService.read(id);
    }
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public PessoaJuridica update(@PathVariable Integer id, @Valid @RequestBody PessoaJuridica entity) {
        return pessoaJuridicaService.update(id,entity);
    }
    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        pessoaJuridicaService.delete(id);
    }
}
