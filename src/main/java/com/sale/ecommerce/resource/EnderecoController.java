package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IEndereco;
import com.sale.ecommerce.model.Endereco;
import com.sale.ecommerce.service.ContatoService;
import com.sale.ecommerce.service.EnderecoService;
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
@RequestMapping(value = "/api/endereco")
@Tag(name = "endereco", description = "documentação do resource endereco")
public class EnderecoController implements IEndereco<Endereco,Integer> {
    @Autowired
    private EnderecoService enderecoService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Cria um endereco",
            description = "Método responsável para criar um endereco no sistema",
            tags = {"endereco"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Endereco.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Endereco create(@Valid @RequestBody Endereco entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return enderecoService.create(entity);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Recupera uma lista de endereco",
            description = "Método responsável para recuperar uma lista de endereco",
            tags = {"endereco"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Endereco.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public List<Endereco> read() {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return enderecoService.read();
    }
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Recupera um endereco baseado em um identificador",
            description = "Método responsável para recuperar um endereco no sistema baseado no identificador",
            tags = {"endereco"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Endereco.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Endereco read(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return enderecoService.read(id);
    }
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de um endereco",
            description = "Método responsável para atualizar todos os dados de um endereco.",
            tags = {"endereco"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Endereco.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Endereco update(@PathVariable Integer id, @Valid @RequestBody Endereco entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return enderecoService.update(id,entity);
    }
    @DeleteMapping(
            value = "/{id}"
    )
    @Operation(
            summary = "Delete um endereco com base no identificador.",
            description = "Método responsável para deletar um endereco com base no identificador.",
            tags = {"endereco"})
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema(implementation = Endereco.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public void delete(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        enderecoService.delete(id);
    }
}
