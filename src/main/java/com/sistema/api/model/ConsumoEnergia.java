package com.sistema.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "consumoenergia")
public class ConsumoEnergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    @JsonBackReference
    private Pais pais;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "consumo_total_gwh")
    private Float consumoTotalGwh;

    @Column(name = "consumo_renovable_gwh")
    private Float consumoRenovableGwh;

    @Column(name = "consumo_industrial_gwh")
    private Float consumoIndustrialGwh;

    @Column(name = "consumo_residencial_gwh")
    private Float consumoResidencialGwh;

    @Column(name = "consumo_comercial_gwh")
    private Float consumoComercialGwh;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}
