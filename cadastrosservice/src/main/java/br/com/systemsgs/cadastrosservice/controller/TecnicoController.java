package br.com.systemsgs.cadastrosservice.controller;

import br.com.systemsgs.cadastrosservice.service.EntidadesInterfaceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tecnicos/v1")
public class TecnicoController {

    private final EntidadesInterfaceService entidadeService;

    public TecnicoController(@Qualifier("tecnicoServiceImpl") EntidadesInterfaceService entidadeService) {
        this.entidadeService = entidadeService;
    }
}
