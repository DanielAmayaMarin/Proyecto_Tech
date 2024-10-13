package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "gestiondatos")
public class GestionDatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_GestionDatos")
    private Integer idGestionDatos;

    @Column(name = "consumoTotal")
    private Float consumoTotal;

    @Column(name = "consumoMensual")
    private Float consumoMensual;

    @Column(name = "consumoanual")
    private Float consumoAnual;

    @Column(name = "consumoXpais")
    private Float consumoXpais;

    @Column(name = "consumoXcontinente")
    private Float consumoXcontinente;

    @Column(name = "mediaXtipo")
    private Float mediaXtipo;

    @Column(name = "mediaXcontinente")
    private Float mediaXcontinente;

    @Column(name = "mediaXpais")
    private Float mediaXpais;

    @Column(name = "mediaTotal")
    private Float mediaTotal;


    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @ManyToMany(mappedBy = "gestiondatos")
    private Set<Energia> energia;

    // Getters and Setters
    public Integer getIdGestionDatos() {
        return idGestionDatos;
    }

    public void setIdGestionDatos(Integer idGestionDatos) {
        this.idGestionDatos = idGestionDatos;
    }

    public Float getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(Float consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public Float getConsumoMensual() {
        return consumoMensual;
    }

    public void setConsumoMensual(Float consumoMensual) {
        this.consumoMensual = consumoMensual;
    }

    public Float getConsumoAnual() {
        return consumoAnual;
    }

    public void setConsumoAnual(Float consumoAnual) {
        this.consumoAnual = consumoAnual;
    }

    public Float getConsumoXpais() {
        return consumoXpais;
    }

    public void setConsumoXpais(Float consumoXpais) {
        this.consumoXpais = consumoXpais;
    }

    public Float getConsumoXcontinente() {
        return consumoXcontinente;
    }

    public void setConsumoXcontinente(Float consumoXcontinente) {
        this.consumoXcontinente = consumoXcontinente;
    }

    public Float getMediaXtipo() {
        return mediaXtipo;
    }

    public void setMediaXtipo(Float mediaXtipo) {
        this.mediaXtipo = mediaXtipo;
    }

    public Float getMediaXcontinente() {
        return mediaXcontinente;
    }

    public void setMediaXcontinente(Float mediaXcontinente) {
        this.mediaXcontinente = mediaXcontinente;
    }

    public Float getMediaXpais() {
        return mediaXpais;
    }

    public void setMediaXpais(Float mediaXpais) {
        this.mediaXpais = mediaXpais;
    }

    public Float getMediaTotal() {
        return mediaTotal;
    }

    public void setMediaTotal(Float mediaTotal) {
        this.mediaTotal = mediaTotal;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
