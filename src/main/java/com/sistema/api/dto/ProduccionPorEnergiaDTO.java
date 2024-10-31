package com.sistema.api.dto;

public class ProduccionPorEnergiaDTO {
    private Integer anio;
    private String pais;
    private Integer mes;
    private Float produccion;
    private String tipoEnergia;

    public ProduccionPorEnergiaDTO(Integer anio, String pais, Integer mes, Float produccion, String tipoEnergia) {
        this.anio = anio;
        this.pais = pais;
        this.mes = mes;
        this.produccion = produccion;
        this.tipoEnergia = tipoEnergia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Float getProduccion() {
        return produccion;
    }

    public void setProduccion(Float produccion) {
        this.produccion = produccion;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }
}
