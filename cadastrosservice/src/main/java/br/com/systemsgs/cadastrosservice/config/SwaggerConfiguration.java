package br.com.systemsgs.cadastrosservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Ordem Serviço Backend",
        description = "Documentação dos endpoints",
        version = "1.0.0"))
public class SwaggerConfiguration {

    public static final String TAG_API_CLIENTES = "Api de Clientes - V1";

}
