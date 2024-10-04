package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @Column(name = "id", length = 10)
    private String id;

    @Column(name = "pais", length = 50)
    private String pais;

    @Column(name = "continente", length = 100)
    private String continente;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
