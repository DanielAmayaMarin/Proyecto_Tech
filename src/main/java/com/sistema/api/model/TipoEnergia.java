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
@Table(name = "tiposenergia")
public class TipoEnergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "es_renovable")
    private Boolean esRenovable;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @OneToMany(mappedBy = "tipoEnergia", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProduccionEnergia> producciones = new ArrayList<>();
}
