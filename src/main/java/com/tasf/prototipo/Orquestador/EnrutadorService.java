package com.tasf.prototipo.Orquestador;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class EnrutadorService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String enrutarPeticion(String prompt, ClasificacionDTO clasificacion) {
        String departamento = clasificacion.getDepartamento();
        
        switch (departamento) {
            case "Administración de software":
                return "[Ruta: Administración] -> Iniciando revisión de credenciales, repositorios o permisos...";
                
            case "Atención al cliente":
                return "[Ruta: Atención al Cliente] -> Formulando respuesta de soporte externo...";
                
            case "Desarrollo de software":
                String urlMicroservicioDesarrollo = "http://localhost:8081/api/desarrollo/resolver";
                
                try {
                    System.out.println("Redirigiendo petición vía HTTP al Microservicio de Desarrollo...");
                    ResponseEntity<String> respuesta = restTemplate.postForEntity(urlMicroservicioDesarrollo, prompt, String.class);
                    return respuesta.getBody();
                } catch (Exception e) {
                    return "[Error] El microservicio de Desarrollo está apagado o inaccesible: " + e.getMessage();
                }
                
            case "QA":
                return "[Ruta: QA] -> Preparando escenario de pruebas y control de calidad...";
                
            case "Recursos humanos":
                return "[Ruta: Recursos Humanos] -> Procesando solicitud de personal o nómina...";
                
            case "Contabilidad":
                return "[Ruta: Contabilidad] -> Revisando registros financieros o presupuestos...";
                
            case "No aplicable":
                return "[Ruta: Bloqueada] -> Petición rechazada. Motivo: " + clasificacion.getMotivo();
                
            default:
                return "[Error de Enrutamiento] -> El orquestador devolvió una categoría no mapeada: " + departamento;
        }
    }
}