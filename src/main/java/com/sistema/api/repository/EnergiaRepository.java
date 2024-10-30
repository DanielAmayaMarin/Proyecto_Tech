package com.sistema.api.repository;


import com.sistema.api.model.Energia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface EnergiaRepository extends JpaRepository<Energia, Integer> {

    @Procedure(name = "GetProduccionTotalPorTipoYAnio")
    List<Object[]> getProduccionTotalPorTipoYAnio(@Param("anio") String anio);

    @Procedure(name = "GetTop10PaisesProduccionEolica")
    List<Object[]> getTop10PaisesProduccionEolica(@Param("anio") String anio);

    @Procedure(name = "GetPorcentajeEnergiaRenovablePorRegion")
    List<Float> getPorcentajeEnergiaRenovablePorRegion(@Param("anio") String anio);

    @Procedure(name = "GetTendenciaEnergiaSolar")
    List<Object[]> getTendenciaEnergiaSolar();

    @Procedure(name = "GetEnergyEfficiency")
    List<Object[]> getEnergyEfficiency();

}
