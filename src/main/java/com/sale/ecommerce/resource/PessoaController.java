package com.sale.ecommerce.resource;


import com.sale.ecommerce.interfaces.IPessoa;
import com.sale.ecommerce.model.Pessoa;
import com.sale.ecommerce.service.ContatoService;
import com.sale.ecommerce.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/pessoa")
@Tag(name = "pessoa", description = "documentação do resource pessoa")
public class PessoaController implements IPessoa<Pessoa,Integer> {
    @Autowired
    private PessoaService pessoaService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Cria uma pessoa",
            description = "Método responsável para criar uma pessoa no sistema",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Pessoa create(@Valid @RequestBody Pessoa entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName());
//                ContatoService.class.getEnclosingMethod().getName());

        return pessoaService.create(entity);
    }
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Recupera uma lista de pessoas",
            description = "Método responsável para recuperar uma lista de pessoas",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public List<Pessoa> read() {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName());
//                ContatoService.class.getEnclosingMethod().getName());
        return pessoaService.read();
    }
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Recupera uma pessoa baseado em um identificador",
            description = "Método responsável para recuperar uma pessoa no sistema baseado no identificador",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
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
    @Operation(
            summary = "Atualiza todos os dados de uma pessoa",
            description = "Método responsável para atualizar todos os dados de uma pessoa.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
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
    @Operation(
            summary = "Delete uma pessoa com base no identificador.",
            description = "Método responsável para deletar uma pessoa com base no identificador.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public void delete(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        pessoaService.delete(id);
    }
}
