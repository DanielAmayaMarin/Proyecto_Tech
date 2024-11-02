package com.sistema.api.dto;

public class PaisDTO {
    private String nombre;
    private Long poblacion;
    private Float area_km2;
    private String continente;

    public PaisDTO(String nombre, Long poblacion, Float area_km2, String continente) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.area_km2 = area_km2;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    public Float getArea_km2() {
        return area_km2;
    }

    public void setArea_km2(Float area_km2) {
        this.area_km2 = area_km2;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
