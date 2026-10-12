package com.tasf.prototipo.Orquestador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agente")
public class OrquestadorController {

    @Autowired
    private AgenteOrquestador agenteOrquestador;

    @Autowired
    private EnrutadorService enrutador;

    @PostMapping("/procesar")
    public String procesarPeticion(@RequestBody String prompt) {
       
        ClasificacionDTO clasificacion = agenteOrquestador.clasificar(prompt);
        return enrutador.enrutarPeticion(prompt, clasificacion);
    }
}