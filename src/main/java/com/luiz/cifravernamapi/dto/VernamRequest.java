
package com.luiz.cifravernamapi.dto;

import jakarta.validation.constraints.NotBlank;

public class VernamRequest {

    @NotBlank(message = "O texto claro não pode estar vazio.")
    private String textoclaro;

    @NotBlank(message = "A chave não pode estar vazia.")
    private String chave;

    public String getTextoClaro() {
        return textoclaro;
    }

    public void setTextoClaro(String textoclaro) {
        this.textoclaro = textoclaro;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
