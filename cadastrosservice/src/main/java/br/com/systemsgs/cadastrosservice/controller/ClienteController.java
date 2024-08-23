package br.com.systemsgs.cadastrosservice.controller;

import br.com.systemsgs.cadastrosservice.dto.request.ModelClientesDTO;
import br.com.systemsgs.cadastrosservice.dto.response.ClienteResponse;
import br.com.systemsgs.cadastrosservice.model.ModelClientes;
import br.com.systemsgs.cadastrosservice.service.ClienteService;
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

import static br.com.systemsgs.cadastrosservice.config.SwaggerConfiguration.TAG_API_CLIENTES;

@Tag(name = TAG_API_CLIENTES)
@RestController
@RequestMapping("/api/clientes/v1")
public class ClienteController {

    private final ClienteService clienteService;
    private final ModelMapper mapper;

    @Autowired
    public ClienteController(ClienteService clienteService, ModelMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @Operation(summary = "Listar Clientes", description = "Api para listar todos os registro de Clientes")
    @GetMapping("/listar/v1")
    public ResponseEntity<List<ClienteResponse>> listarClientes(){
        return ResponseEntity.ok().body(clienteService.listarClientes().
                stream().map(x -> mapper.map(x, ClienteResponse.class))
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Listar Clientes Paginado", description = "Api para listar Clientes Paginados - Padrão (10) Clientes")
    @GetMapping(value = "/listar/v2")
    public Page<ClienteResponse> listarClientesPaginados(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return clienteService.listarClientesPaginado(page, size);
    }

    @Operation(summary = "Pesquisa por ID", description = "Api para listar um Cliente por ID")
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ClienteResponse> pesquisarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(clienteService.pesquisaPorId(id), ClienteResponse.class));
    }

    @Operation(summary = "Salvar Clientes", description = "Api para Salvar um Cliente")
    @PostMapping("/salvar")
    public ResponseEntity<ClienteResponse> salvarCliente(@RequestBody @Valid ModelClientesDTO modelClientesDTO){
        ModelClientes clienteSalvo = clienteService.salvarClientes(modelClientesDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(clienteService.pesquisaPorId(clienteSalvo.getId())).toUri();

        return ResponseEntity.created(uri).body(mapper.map(clienteSalvo, ClienteResponse.class));
    }

    @Operation(summary = "Atualizar Clientes", description = "Api para Atualizar um Cliente pelo Id e Entidade")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteResponse> atualizarClientes(@PathVariable Long id, @RequestBody @Valid ModelClientesDTO modelClientesDTO){
        modelClientesDTO.setId(id);
        ModelClientes clienteAtualizado = clienteService.updateClientes(id, modelClientesDTO);

        return ResponseEntity.ok().body(mapper.map(clienteAtualizado, ClienteResponse.class));
    }

    @Operation(summary = "Deletar Clientes", description = "Api para Deletar um Cliente por ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ModelClientesDTO> delete(@PathVariable Long id){
        clienteService.deletarCliente(id);

        return ResponseEntity.noContent().build();
    }
}
