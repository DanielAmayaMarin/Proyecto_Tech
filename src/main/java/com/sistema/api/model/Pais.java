package com.sistema.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "paises")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "poblacion")
    private Long poblacion;

    @Column(name = "area_km2")
    private Float areaKm2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continente_id")
    @JsonBackReference
    private Continentes continente;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProduccionEnergia> producciones = new ArrayList<>();

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ConsumoEnergia> consumos = new ArrayList<>();
}
