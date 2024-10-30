package com.sistema.api.controller;


import com.sistema.api.model.Energia;
import com.sistema.api.service.EnergiaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/energia")
@SecurityRequirement(name = "bearerAuth")
public class EnergiaController {
    @Autowired
    private EnergiaService energiaService;

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

    @GetMapping("/energy-efficiency")
    public ResponseEntity<?> getEnergyEfficiency(){
        return ResponseEntity.ok(energiaService.getEnergyEfficiency());
    }
}
