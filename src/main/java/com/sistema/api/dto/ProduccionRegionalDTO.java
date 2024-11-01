package com.sistema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProduccionRegionalDTO {


    private String continente;
    private Integer anio;
    private Integer mes;
    private Double consumo_total;
    private Double consumo_comercial;
    private Double consumo_industrial;
    private Double consumo_residencial;
    private Double consumo_renovable;

    public ProduccionRegionalDTO(String continente, Integer anio, Integer mes, Double consumo_total, Double consumo_comercial, Double consumo_industrial, Double consumo_residencial, Double consumo_renovable) {
        this.continente = continente;
        this.anio = anio;
        this.mes = mes;
        this.consumo_total = consumo_total;
        this.consumo_comercial = consumo_comercial;
        this.consumo_industrial = consumo_industrial;
        this.consumo_residencial = consumo_residencial;
        this.consumo_renovable = consumo_renovable;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getConsumo_total() {
        return consumo_total;
    }

    public void setConsumo_total(Double consumo_total) {
        this.consumo_total = consumo_total;
    }

    public Double getConsumo_comercial() {
        return consumo_comercial;
    }

    public void setConsumo_comercial(Double consumo_comercial) {
        this.consumo_comercial = consumo_comercial;
    }

    public Double getConsumo_industrial() {
        return consumo_industrial;
    }

    public void setConsumo_industrial(Double consumo_industrial) {
        this.consumo_industrial = consumo_industrial;
    }

    public Double getConsumo_residencial() {
        return consumo_residencial;
    }

    public void setConsumo_residencial(Double consumo_residencial) {
        this.consumo_residencial = consumo_residencial;
    }

    public Double getConsumo_renovable() {
        return consumo_renovable;
    }

    public void setConsumo_renovable(Double consumo_renovable) {
        this.consumo_renovable = consumo_renovable;
    }
}
