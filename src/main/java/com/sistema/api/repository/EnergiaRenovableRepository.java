//package com.sistema.api.repository;
//
//import com.sistema.api.dto.ProduccionConsumoDTO;
//import com.sistema.api.dto.ProduccionRegionalDTO;
//import com.sistema.api.dto.TopProductoresEolicosDTO;
//import com.sistema.api.model.ProduccionEnergia;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface EnergiaRenovableRepository extends JpaRepository<ProduccionEnergia, Integer> {
//
//    @Query(value = "SELECT " +
//            "    c.nombre as region, " +
//            "    SUM(ce.consumo_total_gwh) as consumo_total, " +
//            "    SUM(ce.consumo_renovable_gwh) as consumo_renovable, " +
//            "    ROUND(SUM(ce.consumo_renovable_gwh) * 100.0 / SUM(ce.consumo_total_gwh), 2) as porcentaje_renovable " +
//            "FROM consumo_energia ce " +
//            "JOIN paises p ON ce.pais_id = p.id " +
//            "JOIN continentes c ON p.continente_id = c.id " +
//            "WHERE ce.anio = :anio " +
//            "GROUP BY c.nombre " +
//            "ORDER BY porcentaje_renovable DESC",
//            nativeQuery = true)
//    List<ProduccionRegionalDTO> obtenerProduccionRenovableRegional(@Param("anio") Integer anio);
//
//    @Query(value = "SELECT p.nombre as pais, " +
//            "SUM(pe.cantidad_gwh) as produccion_eolica, " +
//            "pe.capacidad_instalada_mw as capacidad_instalada, " +
//            "ROUND(SUM(pe.cantidad_gwh) * 100.0 / (" +
//            "    SELECT SUM(cantidad_gwh) " +
//            "    FROM produccion_energia pe2 " +
//            "    JOIN tipos_energia te2 ON pe2.tipo_energia_id = te2.id " +
//            "    WHERE te2.nombre = 'Eólica'" +
//            "), 2) as porcentaje_total " +
//            "FROM produccion_energia pe " +
//            "JOIN paises p ON pe.pais_id = p.id " +
//            "JOIN tipos_energia te ON pe.tipo_energia_id = te.id " +
//            "WHERE te.nombre = 'Eólica' " +
//            "GROUP BY p.nombre, pe.capacidad_instalada_mw " +
//            "ORDER BY produccion_eolica DESC " +
//            "LIMIT 10", nativeQuery = true)
//    List<TopProductoresEolicosDTO> obtenerTopProductoresEolicos();
//
//    @Query("SELECT pe.anio, pe.mes,SUM(pe.cantidad_gwh) as produccion,SUM(ce.consumo_total_gwh) as consumo FROM produccion_energia pe JOIN consumo_energia ce ON pe.pais_id = ce.pais_id AND pe.anio = ce.anio AND pe.mes = ce.mes WHERE pe.anio = :anio GROUP BY pe.anio, pe.mes ORDER BY pe.anio, pe.mes")
//    List<ProduccionConsumoDTO> obtenerTendenciaProduccionConsumo(@Param("anio") Integer anio);
//
//}
