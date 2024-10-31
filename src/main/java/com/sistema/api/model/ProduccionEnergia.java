package com.sistema.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sistema.api.dto.DashboardMetricasDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(
        name = "GetObtenerMetricasPrincipales",
        procedureName = "GetObtenerMetricasPrincipales",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "anio", type = Integer.class)
        }
)
@NamedStoredProcedureQuery(
        name = "GetFuentesDeEnergiaRenovable",
        procedureName = "GetFuentesDeEnergiaRenovable"
)
@NamedStoredProcedureQuery(
        name = "GetProduccionPorEnergia",
        procedureName = "GetProduccionPorEnergia"
)
@Table(name = "produccionenergia")
public class ProduccionEnergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    @JsonBackReference
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_energia_id")
    @JsonBackReference
    private TipoEnergia tipoEnergia;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "cantidad_gwh")
    private Float cantidadGwh;

    @Column(name = "capacidad_instalada_mw")
    private Float capacidadInstaladaMw;

    @Column(name = "factor_capacidad")
    private Float factorCapacidad;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}
