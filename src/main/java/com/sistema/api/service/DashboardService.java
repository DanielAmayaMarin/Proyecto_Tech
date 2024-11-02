package com.sistema.api.service;

import com.sistema.api.dto.DashboardMetricasDTO;
import com.sistema.api.dto.EnergiasRenovablesPorRegionDTO;
import com.sistema.api.dto.ProduccionPorEnergiaDTO;
import com.sistema.api.dto.ProduccionRegionalDTO;
import com.sistema.api.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional()
public class DashboardService {


    @Autowired
    private DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public Optional<DashboardMetricasDTO>  obtenerMetricasPrincipales(Integer anio) {
        List<Object[]> resultados = dashboardRepository.obtenerMetricasPrincipales(anio);
        if (resultados.isEmpty()) return Optional.empty();
        Object[] resultado = resultados.get(0);
        Double produccionTotal = (Double) resultado[0];
        Double consumoTotal = (Double) resultado[1];
        Double eficiencia = (Double) resultado[2];
        DashboardMetricasDTO metricasDTO = new DashboardMetricasDTO(produccionTotal, consumoTotal, eficiencia);
        return Optional.of(metricasDTO);
    }

    public List<Object[]> fuentesDeEnergiaRenovable(){
        return dashboardRepository.fuentesDeEnergiaRenovable();
    }

    public List<ProduccionPorEnergiaDTO> produccionPorEnergia(){
        List<Object[]> resultados = dashboardRepository.produccionPorEnergia();
        return resultados.stream()
                .map(resultado -> new ProduccionPorEnergiaDTO(
                        (Integer) resultado[0],
                        (String) resultado[1],
                        (Integer) resultado[2],
                        (Float) resultado[3],
                        (String) resultado[4]
                ))
                .collect(Collectors.toList());
    }


    public List<ProduccionRegionalDTO> consumoEnergetico(){
        List<Object[]> resultados = dashboardRepository.consumoEnergetico();

        return resultados.stream()
                .map(resultado -> new ProduccionRegionalDTO(
                        (String) resultado[0],
                        (Integer) resultado[1],
                        (Integer) resultado[2],
                        (Double) resultado[3],
                        (Double) resultado[4],
                        (Double) resultado[5],
                        (Double) resultado[6],
                        (Double) resultado[7]
                ))
                .collect(Collectors.toList());
    }

    public List<EnergiasRenovablesPorRegionDTO> energiasRenovablesPorRegion(Integer anio){
        List<Object[]> resultados = dashboardRepository.energiasRenovablesPorRegion(anio);
        return resultados.stream()
                .map(resultado -> new EnergiasRenovablesPorRegionDTO(
                        (String) resultado[0],
                        (Double) resultado[1],
                        (Double) resultado[2],
                        (Double) resultado[3]
                ))
                .collect(Collectors.toList());
    }
}
