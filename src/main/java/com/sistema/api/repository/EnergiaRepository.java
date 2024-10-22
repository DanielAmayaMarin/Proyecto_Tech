package com.sistema.api.repository;


import com.sistema.api.model.Energia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EnergiaRepository extends JpaRepository<Energia, Integer> {
    @Query("SELECT e.tipo_energia, SUM(e.produccion) as totalProduccion FROM energia e WHERE e.anio = ?1 GROUP BY e.tipo_energia, e.pais ORDER BY totalProduccion DESC")
    List<Object[]> getProduccionTotalPorTipoYAnio(String anio);

    @Query("SELECT e.pais, SUM(e.produccion) as totalProduccion FROM energia e WHERE e.tipo_energia = 'Eólica' AND e.anio = ?1 GROUP BY e.pais ORDER BY totalProduccion DESC")
    List<Object[]> getTop10PaisesProduccionEolica(String anio);

    @Query("SELECT SUM(e.produccion) / SUM(e.consumo) * 100 FROM Energia e WHERE e.anio = ?1 GROUP BY e.pais")
    List<Float> getPorcentajeEnergiaRenovablePorRegion(String anio);

    @Query("SELECT e.anio, SUM(e.produccion) FROM Energia e WHERE e.tipoEnergia = 'Solar' GROUP BY e.anio ORDER BY e.anio")
    List<Object[]> getTendenciaEnergíaSolar();
}
