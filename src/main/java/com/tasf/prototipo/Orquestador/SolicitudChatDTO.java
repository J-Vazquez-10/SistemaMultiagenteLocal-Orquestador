package com.tasf.prototipo.Orquestador;

public class SolicitudChatDTO {
    private String prompt;

    public SolicitudChatDTO() {}

    public SolicitudChatDTO(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}