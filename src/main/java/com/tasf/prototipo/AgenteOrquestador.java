package com.tasf.prototipo;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AgenteOrquestador {
    
    // {{it}} inyecta automáticamente el String que le pases como parámetro
    @UserMessage("{{it}}")
    String clasificar(String peticion);
}