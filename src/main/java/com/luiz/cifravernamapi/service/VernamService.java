
package com.luiz.cifravernamapi.service;

import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

@Service
public class VernamService {

    public String cifrar(String textoClaro, String chave) {

        byte[] textoBytes = textoClaro.getBytes(StandardCharsets.UTF_8);
        byte[] chaveBytes = chave.getBytes(StandardCharsets.UTF_8);

        if (textoBytes.length != chaveBytes.length) {
            throw new IllegalArgumentException(
                "A chave deve possuir o mesmo tamanho do texto claro em bytes."
            );
        }

        StringBuilder binario = new StringBuilder();

        for (int i = 0; i < textoBytes.length; i++) {
            byte resultado = (byte) (textoBytes[i] ^ chaveBytes[i]);

            String bits = String.format(
                "%8s",
                Integer.toBinaryString(resultado & 0xFF)
            ).replace(' ', '0');

            binario.append(bits);
        }

        return binario.toString();
    }

    public String decifrar(String textoCifrado, String chave) {

        if (textoCifrado == null ||
            textoCifrado.isEmpty() ||
            !textoCifrado.matches("[01]+") ||
            textoCifrado.length() % 8 != 0) {

            throw new IllegalArgumentException(
                "O texto cifrado deve conter apenas 0 e 1, em grupos de 8 bits."
            );
        }

        byte[] chaveBytes = chave.getBytes(StandardCharsets.UTF_8);

        if (textoCifrado.length() / 8 != chaveBytes.length) {
            throw new IllegalArgumentException(
                "A chave deve possuir o mesmo tamanho do texto cifrado em bytes."
            );
        }

        byte[] resultado = new byte[chaveBytes.length];

        for (int i = 0; i < resultado.length; i++) {
            String grupo = textoCifrado.substring(i * 8, (i + 1) * 8);

            byte valor = (byte) Integer.parseInt(grupo, 2);

            resultado[i] = (byte) (valor ^ chaveBytes[i]);
        }

        return new String(resultado, StandardCharsets.UTF_8);
    }
}
