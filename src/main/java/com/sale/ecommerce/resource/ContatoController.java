package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IContato;
import com.sale.ecommerce.model.Contato;
import com.sale.ecommerce.service.ContatoService;
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

import java.awt.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/contato")
@Tag(name = "contato", description = "documentação do resource contato")
public class ContatoController implements IContato<Contato,Integer> {

    @Autowired
    private ContatoService contatoService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Cria um Contato",
            description = "Método responsável para criar um contato no sistema",
            tags = {"contato"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Contato.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Contato create(@Valid @RequestBody Contato entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return contatoService.create(entity);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Recupera uma lista de contato",
            description = "Método responsável para recuperar uma lista de contatos",
            tags = {"contato"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Contato.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public List<Contato> read() {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return contatoService.read();
    }


    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Recupera um contato baseado em um identificador",
            description = "Método responsável para recuperar um contato no sistema baseado no identificador",
            tags = {"contato"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Contato.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Contato read(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return contatoService.read(id);
    }


    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de um contato",
            description = "Método responsável para atualizar todos os dados de um contato.",
            tags = {"contato"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Contato.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Contato update(@PathVariable Integer id, @Valid @RequestBody Contato entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return contatoService.update(id,entity);
    }

    @Override
    @DeleteMapping(
            value = "/{id}"
    )
    @Operation(
            summary = "Delete um contato com base no identificador.",
            description = "Método responsável para deletar um contato com base no identificador.",
            tags = {"contato"})
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema(implementation = Contato.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public void delete(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        contatoService.delete(id);
    }
}
