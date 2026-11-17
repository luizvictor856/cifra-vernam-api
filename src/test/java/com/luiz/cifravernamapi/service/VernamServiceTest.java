
package com.luiz.cifravernamapi.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VernamServiceTest {

    @Test
    public void deveCifrarEDecifrarMensagem() {

        VernamService service = new VernamService();

        String mensagem = "OLA MUNDO";
        String chave = "123456789";

        String mensagemCifrada = service.cifrar(mensagem, chave);

        assertTrue(mensagemCifrada.matches("[01]+"));

        String mensagemOriginal = service.decifrar(
            mensagemCifrada,
            chave
        );

        assertEquals(mensagem, mensagemOriginal);
    }
}
