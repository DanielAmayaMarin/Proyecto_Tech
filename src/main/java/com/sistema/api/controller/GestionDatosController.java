package com.sistema.api.controller;

import com.sistema.api.model.Energia;
import com.sistema.api.model.GestionDatos;
import com.sistema.api.service.EnergiaService;
import com.sistema.api.service.GestionDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-datos")
public class GestionDatosController {
    @Autowired
    private GestionDatosService gestionDatosService;

    @GetMapping
    public ResponseEntity<List<GestionDatos>> obtenerTodosGestionDatos() {
        return ResponseEntity.ok(gestionDatosService.obtenerTodosGestionDatos());
    }

    @PostMapping
    public ResponseEntity<GestionDatos> guardarGestionDatos(@RequestBody GestionDatos gestionDatos) {
        return ResponseEntity.ok(gestionDatosService.guardarGestionDatos(gestionDatos));
    }

    @PutMapping("/gestion-datos/{id}")
    public GestionDatos actualizargestiondatos(@PathVariable Long id, @RequestBody GestionDatos GestionDatos) {
        return GestionDatosService.actualizarGestionDatos(id, GestionDatos);
    }

}
