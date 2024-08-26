package br.com.systemsgs.financeiroservice.controller;

import br.com.systemsgs.financeiroservice.dto.request.ModelContasReceberDTO;
import br.com.systemsgs.financeiroservice.dto.response.ContasReceberResponse;
import br.com.systemsgs.financeiroservice.service.ContasReceberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static br.com.systemsgs.financeiroservice.config.SwaggerConfiguration.TAG_API_CONTAS_RECEBER;

@Tag(name = TAG_API_CONTAS_RECEBER)
@RestController
@RequestMapping("/api/contasreceber/v1")
public class ContasReceberController {

    private final ContasReceberService contasReceberService;

    @Autowired
    public ContasReceberController(ContasReceberService contasReceberService) {
        this.contasReceberService = contasReceberService;
    }

    @Operation(summary = "Listar Contas a Receber", description = "Api para listar todos os registro de Contas a Receber")
    @GetMapping("/listar")
    public ResponseEntity<List<ContasReceberResponse>> listarContasReceber(){
        return ResponseEntity.ok().body(contasReceberService.listarContasReceber());
    }

    @Operation(summary = "Listar Contas a Receber Paginada", description = "Api para listar Contas a Receber Paginadas - Padrão (10) Contas")
    @GetMapping(value = "/listar/v2")
    public Page<ContasReceberResponse> listarContasReceberPaginada(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return contasReceberService.listarContasReceberPaginada(page, size);
    }

    @Operation(summary = "Pesquisa por ID", description = "Api para listar uma Conta a Receber por ID")
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ContasReceberResponse> pesquisarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(contasReceberService.pesquisaPorId(id));
    }

    @Operation(summary = "Cadastrar Contas a Receber", description = "Api para Salvar uma Conta a Receber")
    @PostMapping("/salvar")
    public ResponseEntity<ContasReceberResponse> salvarContasReceber(@RequestBody @Valid ModelContasReceberDTO modelContasReceberDTO){
        var contaReceberSalva = contasReceberService.cadastrarContasReceber(modelContasReceberDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(contasReceberService.pesquisaPorId(contaReceberSalva.getId())).toUri();

        return ResponseEntity.created(uri).body(contaReceberSalva);
    }

    @Operation(summary = "Atualizar uma Conta a Receber", description = "Api para Atualizar uma Conta a Receber pelo Id e Entidade")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ContasReceberResponse> atualizarContasReceber(@PathVariable Long id, @RequestBody @Valid ModelContasReceberDTO modelContasReceberDTO){
        modelContasReceberDTO.setId(id);

        return ResponseEntity.ok().body(contasReceberService.alterarContasReceber(id, modelContasReceberDTO));
    }

    @Operation(summary = "Deletar Contas a Receber", description = "Api para Deletar uma Conta a Receber por ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ContasReceberResponse> delete(@PathVariable Long id){
        contasReceberService.deletarContasReceber(id);

        return ResponseEntity.noContent().build();
    }
}
