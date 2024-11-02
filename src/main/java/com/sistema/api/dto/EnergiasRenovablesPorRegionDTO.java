package com.sistema.api.dto;

public class EnergiasRenovablesPorRegionDTO {
    private String region;
    private Double consumo_total;
    private Double consumo_renovable;
    private Double porcentaje_renovable;


    public EnergiasRenovablesPorRegionDTO(String region, Double consumo_total, Double consumo_renovable, Double porcentaje_renovable) {
        this.region = region;
        this.consumo_total = consumo_total;
        this.consumo_renovable = consumo_renovable;
        this.porcentaje_renovable = porcentaje_renovable;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getConsumo_total() {
        return consumo_total;
    }

    public void setConsumo_total(Double consumo_total) {
        this.consumo_total = consumo_total;
    }

    public Double getConsumo_renovable() {
        return consumo_renovable;
    }

    public void setConsumo_renovable(Double consumo_renovable) {
        this.consumo_renovable = consumo_renovable;
    }

    public Double getPorcentaje_renovable() {
        return porcentaje_renovable;
    }

    public void setPorcentaje_renovable(Double porcentaje_renovable) {
        this.porcentaje_renovable = porcentaje_renovable;
    }
}
