
package com.luiz.cifravernamapi.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.stereotype.Service;

@Service
public class VernamService {

    public String cifrar(String textoClaro, String chave) {

        byte[] textoClaroBytes = textoClaro.getBytes(StandardCharsets.UTF_8);
        byte[] chaveBytes = chave.getBytes(StandardCharsets.UTF_8);

        if (textoClaroBytes.length != chaveBytes.length) {
            throw new IllegalArgumentException(
                "A chave deve possuir o mesmo tamanho do texto claro em bytes."
            );
        }

        byte[] resultado = new byte[textoClaroBytes.length];

        for (int i = 0; i < textoClaroBytes.length; i++) {
            resultado[i] = (byte) (textoClaroBytes[i] ^ chaveBytes[i]);
        }

        return Base64.getEncoder().encodeToString(resultado);
    }

    public String decifrar(String textoCifrado, String chave) {

        byte[] textoCifradoBytes = Base64.getDecoder().decode(textoCifrado);
        byte[] chaveBytes = chave.getBytes(StandardCharsets.UTF_8);

        if (textoCifradoBytes.length != chaveBytes.length) {
            throw new IllegalArgumentException(
                "A chave deve possuir o mesmo tamanho do texto cifrado em bytes."
            );
        }

        byte[] resultado = new byte[textoCifradoBytes.length];

        for (int i = 0; i < textoCifradoBytes.length; i++) {
            resultado[i] = (byte) (textoCifradoBytes[i] ^ chaveBytes[i]);
        }

        return new String(resultado, StandardCharsets.UTF_8);
    }
}
