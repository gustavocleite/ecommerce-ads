package com.sale.ecommerce.resource;

import com.sale.ecommerce.interfaces.IEmail;
import com.sale.ecommerce.model.Contato;
import com.sale.ecommerce.model.Email;
import com.sale.ecommerce.service.ContatoService;
import com.sale.ecommerce.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/email")
@Tag(name = "email", description = "documentação do resource email")
public class EmailController implements IEmail<Email,Integer> {
    @Autowired
    private EmailService emailService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Cria um Email",
            description = "Método responsável para criar um Email no sistema",
            tags = {"email"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Email.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Email create(@RequestBody Email entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return emailService.create(entity);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Operation(
            summary = "Recupera uma lista de mail",
            description = "Método responsável para recuperar uma lista de email",
            tags = {"email"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Email.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public List<Email> read() {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return emailService.read();
    }
    @GetMapping(value = "/{id}")
    @Override
    @Operation(
            summary = "Recupera um email baseado em um identificador",
            description = "Método responsável para recuperar um email no sistema baseado no identificador",
            tags = {"email"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Email.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public Email read(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return emailService.read(id);
    }
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de um email",
            description = "Método responsável para atualizar todos os dados de um email.",
            tags = {"email"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Email.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public Email update(Integer id, @RequestBody Email entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return emailService.update(id,entity);
    }
    @DeleteMapping(
            value = "/{id}"
    )
    @Operation(
            summary = "Delete um email com base no identificador.",
            description = "Método responsável para deletar um email com base no identificador.",
            tags = {"email"})
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema(implementation = Email.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Override
    public void delete(@RequestBody Integer id) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        emailService.delete(id);
    }
}
