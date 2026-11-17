
package com.luiz.cifravernamapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luiz.cifravernamapi.dto.VernamRequest;
import com.luiz.cifravernamapi.service.VernamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vernam")
public class VernamController {

    private final VernamService vernamService;

    public VernamController(VernamService vernamService) {
        this.vernamService = vernamService;
    }

    @PostMapping(
        value = "/cifrar",
        produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> cifrar(
            @Valid @RequestBody VernamRequest request) {

        String resultado = vernamService.cifrar(
            request.getTextoClaro(),
            request.getChave()
        );

        return ResponseEntity.ok(resultado);
    }

    @PostMapping(
        value = "/decifrar",
        consumes = MediaType.TEXT_PLAIN_VALUE,
        produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> decifrar(
            @RequestBody String textoCifrado,
            @RequestParam String chave) {

        String resultado = vernamService.decifrar(
            textoCifrado,
            chave
        );

        return ResponseEntity.ok(resultado);
    }
}
