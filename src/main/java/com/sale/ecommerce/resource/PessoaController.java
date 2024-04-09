package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IEndereco;
import com.sale.ecommerce.interfaces.IPessoa;
import com.sale.ecommerce.model.Pessoa;
import com.sale.ecommerce.service.ContatoService;
import com.sale.ecommerce.service.PessoaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pessoa")
public class PessoaController implements IPessoa<Pessoa,Integer> {
    @Autowired
    private PessoaService pessoaService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Pessoa create(@Valid @RequestBody Pessoa entity) {
//        log.info("Resource: {}, método: {}",
//                ContatoService.class.getCanonicalName(),
//                ContatoService.class.getEnclosingMethod().getName());
        return pessoaService.create(entity);
    }
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public List<Pessoa> read() {
//        log.info("Resource: {}, método: {}",
//                ContatoService.class.getCanonicalName(),
//                ContatoService.class.getEnclosingMethod().getName());
        return pessoaService.read();
    }
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public Pessoa read(Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return pessoaService.read(id);
    }
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Pessoa update(@PathVariable Integer id, @Valid @RequestBody Pessoa entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return pessoaService.update(id,entity);
    }
    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        pessoaService.delete(id);
    }
}
