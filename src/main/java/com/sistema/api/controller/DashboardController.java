package com.sistema.api.controller;

import com.sistema.api.service.DashboardService;
import com.sistema.api.util.ResponseUtil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
@SecurityRequirement(name = "bearerAuth")
public class DashboardController {

   @Autowired
   private DashboardService dashboardService;

   @GetMapping("/obtener-metricas-principales/{anio}")
    public ResponseEntity<?> getProduccionTotalPorTipoYAnio(@PathVariable Integer anio) {
      System.out.println(anio);
       return ResponseUtil.buildSuccessResponse(dashboardService.obtenerMetricasPrincipales(anio),"Metricas principales");
   }

   @GetMapping("/fuentes-de-energia-renovable")
   public ResponseEntity<?> getFuentesDeEnergiaRenovable() {
      return ResponseUtil.buildSuccessResponse(dashboardService.fuentesDeEnergiaRenovable(),"Fuentes de energia renovable");
   }

   @GetMapping("/produccion-por-energia")
   public ResponseEntity<?> getProduccionPorEnergia() {
      return ResponseUtil.buildSuccessResponse(dashboardService.produccionPorEnergia(),"Producción por energia");
   }

    @GetMapping("/consumo-energetico")
    public ResponseEntity<?> getConsumoEnergetico() {
        return ResponseUtil.buildSuccessResponse(dashboardService.consumoEnergetico(),"Consumo energetico");
    }
}
