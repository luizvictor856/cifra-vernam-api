
package com.luiz.cifravernamapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.cifravernamapi.dto.VernamRequest;
import com.luiz.cifravernamapi.dto.VernamResponse;
import com.luiz.cifravernamapi.service.VernamService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vernam")
public class VernamController {

    private final VernamService vernamService;

    public VernamController(VernamService vernamService) {
        this.vernamService = vernamService;
    }

    @PostMapping("/cifrar")
    public VernamResponse cifrar(@Valid @RequestBody VernamRequest request) {

        String resultado = vernamService.cifrar(
            request.getTextoClaro(),
            request.getChave()
        );

        VernamResponse response = new VernamResponse();
        response.setResultado(resultado);

        return response;
    }

    @PostMapping("/decifrar")
    public VernamResponse decifrar(@Valid @RequestBody VernamRequest request) {

        String resultado = vernamService.decifrar(
            request.getTextoClaro(),
            request.getChave()
        );

        VernamResponse response = new VernamResponse();
        response.setResultado(resultado);

        return response;
    }
}
