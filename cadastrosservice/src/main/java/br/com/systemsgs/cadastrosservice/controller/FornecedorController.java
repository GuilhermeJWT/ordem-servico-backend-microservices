package br.com.systemsgs.cadastrosservice.controller;

import br.com.systemsgs.cadastrosservice.dto.request.ModelFornecedorDTO;
import br.com.systemsgs.cadastrosservice.model.ModelFornecedor;
import br.com.systemsgs.cadastrosservice.service.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.systemsgs.cadastrosservice.config.SwaggerConfiguration.TAG_API_FORNECEDOR;

@Tag(name = TAG_API_FORNECEDOR)
@RestController
@RequestMapping("/api/fornecedores/v1")
public class FornecedorController {

    private final FornecedorService fornecedorServiceService;
    private final ModelMapper mapper;

    @Autowired
    public FornecedorController(FornecedorService fornecedorServiceService, ModelMapper mapper) {
        this.fornecedorServiceService = fornecedorServiceService;
        this.mapper = mapper;
    }

    @Operation(summary = "Listar Fornecedores", description = "Api para listar todos os registro de Fornecedores")
    @GetMapping("/listar")
    public ResponseEntity<List<ModelFornecedorDTO>> listarFornecedores(){
       return ResponseEntity.ok().body(fornecedorServiceService.listarFornecedores().
               stream().map(x -> mapper.map(x, ModelFornecedorDTO.class))
               .collect(Collectors.toList()));
    }

    @Operation(summary = "Listar Forncedores Paginados", description = "Api para listar Fornecedores Paginados - Padrão (10) Contas")
    @GetMapping(value = "/listar/v2")
    public Page<ModelFornecedorDTO> listarFornecedoresPaginado(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return fornecedorServiceService.listarFornecedoresPaginados(page, size);
    }

    @Operation(summary = "Pesquisa por ID", description = "Api para listar um Fornecedor por ID")
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ModelFornecedorDTO> pesquisarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(fornecedorServiceService.pesquisaPorId(id), ModelFornecedorDTO.class));
    }

    @Operation(summary = "Salvar Fornecedores", description = "Api para Salvar um Fornecedor")
    @PostMapping("/salvar")
    public ResponseEntity<ModelFornecedorDTO> salvarFornecedores(@RequestBody @Valid ModelFornecedorDTO modelFornecedorDTO){
        ModelFornecedor fornecedorSalvo = fornecedorServiceService.salvarFornecedor(modelFornecedorDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(fornecedorServiceService.pesquisaPorId(fornecedorSalvo.getId())).toUri();

        return ResponseEntity.created(uri).body(mapper.map(fornecedorSalvo, ModelFornecedorDTO.class));
    }

    @Operation(summary = "Atualizar Fornecedores", description = "Api para Atualizar um Fornecedor pelo Id e Entidade")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ModelFornecedorDTO> atualizarFornecedores(@PathVariable Long id, @RequestBody @Valid ModelFornecedorDTO modelFornecedorDTO){
        modelFornecedorDTO.setId(id);
        ModelFornecedor fornecedorAtualizado = fornecedorServiceService.updateFornecedor(id, modelFornecedorDTO);

        return ResponseEntity.ok().body(mapper.map(fornecedorAtualizado, ModelFornecedorDTO.class));
    }

    @Operation(summary = "Deletar Fornecedores", description = "Api para Deletar um Fornecedor por ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ModelFornecedorDTO> delete(@PathVariable Long id){
        fornecedorServiceService.deletarFornecedor(id);

        return ResponseEntity.noContent().build();
    }
}
