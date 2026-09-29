package com.tasf.prototipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agente")
public class OrquestadorController {

    @Autowired
    private AgenteOrquestador agente;

    @PostMapping("/clasificar")
    public String recibirPeticion(@RequestBody String prompt) {
        return agente.clasificar(prompt);
    }
}