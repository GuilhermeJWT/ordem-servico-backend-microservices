package br.com.systemsgs.cadastrosservice.controller;

import br.com.systemsgs.cadastrosservice.service.EntidadesInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fornecedores/v1")
public class FornecedorController {

    private final EntidadesInterfaceService entidadeService;

    @Autowired
    public FornecedorController(EntidadesInterfaceService entidadeService) {
        this.entidadeService = entidadeService;
    }
}
