package com.sistema.api.controller;

import com.sistema.api.model.Pais;
import com.sistema.api.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> obtenerTodosPaises() {
        return ResponseEntity.ok(paisService.obtenerTodosPaises());
    }

    @PostMapping
    public ResponseEntity<Pais> guardarPais(@RequestBody Pais pais) {
        return ResponseEntity.ok(paisService.guardarPais(pais));
    }
}
