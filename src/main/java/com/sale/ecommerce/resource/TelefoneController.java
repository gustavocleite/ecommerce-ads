package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.ITelefone;
import com.sale.ecommerce.model.Telefone;
import com.sale.ecommerce.service.TelefoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/telefone")
public class TelefoneController implements ITelefone<Telefone,Integer> {
    @Autowired
    private TelefoneService telefoneService;
    @PostMapping
    @Override
    public Telefone create(@RequestBody Telefone entity) {
        return telefoneService.create(entity);
    }
    @GetMapping
    @Override
    public List<Telefone> read() {
        return telefoneService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    public Telefone read(@PathVariable Integer id) {
        return telefoneService.read(id);
    }
    @PutMapping(value = "/{id}")
    @Override
    public Telefone update(@PathVariable Integer id,@RequestBody Telefone entity) {
        return telefoneService.update(id,entity);
    }
    @DeleteMapping
    @Override
    public void delete(@RequestBody Integer id) {
        telefoneService.delete(id);
    }
}
