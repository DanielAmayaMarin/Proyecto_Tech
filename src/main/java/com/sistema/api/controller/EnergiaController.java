package com.sistema.api.controller;


import com.sistema.api.model.Energia;
import com.sistema.api.service.EnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/energia")
public class EnergiaController {
    @Autowired
    private EnergiaService energiaService;
    private Energia energia;


    @GetMapping("/produccion/{anio}")
    public ResponseEntity<?> getProduccionTotalPorTipoYAnio(@PathVariable String anio) {
        return ResponseEntity.ok(energiaService.getProduccionTotalPorTipoYAnio(anio));
    }

    @GetMapping("/top-eolica/{anio}")
    public ResponseEntity<?> getTop10PaisesProduccionEolica(@PathVariable String anio) {
        return ResponseEntity.ok(energiaService.getTop10PaisesProduccionEolica(anio));
    }

    @GetMapping("/porcentaje-renovable/{anio}")
    public ResponseEntity<?> getPorcentajeEnergiaRenovablePorRegion(@PathVariable String anio) {
        return ResponseEntity.ok(energiaService.getPorcentajeEnergiaRenovablePorRegion(anio));
    }

    @GetMapping("/tendencia-solar")
    public ResponseEntity<?> getTendenciaEnergíaSolar() {
        return ResponseEntity.ok(energiaService.getTendenciaEnergíaSolar());
    }

    @PostMapping
    public ResponseEntity<Energia> guardarEnergia(@RequestBody Energia energia) {
        return ResponseEntity.ok(energiaService.guardarEnergia(energia));
    }

    @PutMapping("/Energia/{id}")
    public Energia actualizarEnergia(@PathVariable Long id, @RequestBody Energia Energia) {
        return EnergiaService.actualizarEnergia(id, Energia);
    }

    @DeleteMapping("/Energia/{id}")
    public ResponseEntity<?> eliminarEnergia(@RequestBody Energia energia) {
        this.energia = energia;
        EnergiaService.eliminarEnergia(id);
        return ResponseEntity.ok().build();
    }

}
