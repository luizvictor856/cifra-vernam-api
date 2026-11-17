
package com.luiz.cifravernamapi.dto;

import jakarta.validation.constraints.NotBlank;
import com.luiz.cifravernamapi.dto.VernamDecifrarRequest;

public class VernamDecifrarRequest {

    @NotBlank(message = "O texto cifrado não pode estar vazio.")
    private String textoCifrado;

    @NotBlank(message = "A chave não pode estar vazia.")
    private String chave;

    public String getTextoCifrado() {
        return textoCifrado;
    }

    public void setTextoCifrado(String textoCifrado) {
        this.textoCifrado = textoCifrado;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
