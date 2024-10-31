package com.sistema.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "continentes")
public class Continentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "continente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pais> paises = new ArrayList<>();
}
