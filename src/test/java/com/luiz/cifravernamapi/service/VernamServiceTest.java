
package com.luiz.cifravernamapi.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VernamServiceTest {

    @Test
    public void deveCriptografarEDescriptografarMensagem() {

        VernamService service = new VernamService();

        String mensagem = "OLA MUNDO";
        String chave = "123456789";

        // Criptografando a mensagem
        String mensagemCriptografada =
                service.cifrar(mensagem, chave);

        // Verificando se o resultado é diferente da mensagem original
        assertNotEquals(mensagem, mensagemCriptografada);

        // Descriptografando a mensagem
        String mensagemOriginal =
                service.decifrar(mensagemCriptografada, chave);

        // Verificando se recuperamos a mensagem original
        assertEquals(mensagem, mensagemOriginal);
    }
}
