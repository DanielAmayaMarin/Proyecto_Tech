package com.sistema.api.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class DashboardMetricasDTO {
    private Double produccion_total;
    private Double consumo_total;
    private Double eficiencia;

    public DashboardMetricasDTO(Double produccion_total, Double consumo_total, Double eficiencia) {
        this.produccion_total = produccion_total;
        this.consumo_total = consumo_total;
        this.eficiencia = eficiencia;
    }

    public Double getProduccion_total() {
        return produccion_total;
    }

    public void setProduccion_total(Double produccion_total) {
        this.produccion_total = produccion_total;
    }

    public Double getConsumo_total() {
        return consumo_total;
    }

    public void setConsumo_total(Double consumo_total) {
        this.consumo_total = consumo_total;
    }

    public Double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(Double eficiencia) {
        this.eficiencia = eficiencia;
    }
}
