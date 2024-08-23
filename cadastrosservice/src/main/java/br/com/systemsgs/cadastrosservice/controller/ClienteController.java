package br.com.systemsgs.cadastrosservice.controller;

import br.com.systemsgs.cadastrosservice.service.EntidadesInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes/v1")
public class ClienteController {

    private final EntidadesInterfaceService entidadeService;

    @Autowired
    public ClienteController(@Qualifier("clienteService")EntidadesInterfaceService entidadeService) {
        this.entidadeService = entidadeService;
    }
}
