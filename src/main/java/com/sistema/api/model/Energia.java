package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "energia")
public class Energia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_energia")
    private Integer idEnergia;

    @Column(name = "tipoEnergia", length = 50)
    private String tipoEnergia;

    @Column(name = "pais", length = 100)
    private String pais;

    @Column(name = "anio", length = 15)
    private String anio;

    @Column(name = "consumo")
    private Float consumo;

    @Column(name = "produccion")
    private Float produccion;

    @ManyToOne
    @JoinColumn(name = "usuario_cedula", referencedColumnName = "cedula")
    private Usuario usuario;

    // Getters and Setters
    public Integer getIdEnergia() {
        return idEnergia;
    }

    public void setIdEnergia(Integer idEnergia) {
        this.idEnergia = idEnergia;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Float getConsumo() {
        return consumo;
    }

    public void setConsumo(Float consumo) {
        this.consumo = consumo;
    }

    public Float getProduccion() {
        return produccion;
    }

    public void setProduccion(Float produccion) {
        this.produccion = produccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
