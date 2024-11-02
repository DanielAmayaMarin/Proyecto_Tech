package com.sistema.api.repository;

import com.sistema.api.model.ProduccionEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DashboardRepository extends JpaRepository<ProduccionEnergia, Integer> {

    @Procedure(name="GetObtenerMetricasPrincipales")
    List<Object[]>  obtenerMetricasPrincipales(@Param("anio") Integer anio);

    @Procedure(name="GetFuentesDeEnergiaRenovable")
    List<Object[]> fuentesDeEnergiaRenovable ();

    @Procedure(name="GetProduccionPorEnergia")
    List<Object[]> produccionPorEnergia ();

    @Procedure(name="GetConsumoEnergetico")
    List<Object[]> consumoEnergetico ();

    @Procedure(name="GetRenewableEnergyByRegion")
    List<Object[]> energiasRenovablesPorRegion(@Param("anio") Integer anio);

}
