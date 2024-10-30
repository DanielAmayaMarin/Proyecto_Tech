package com.sistema.api.service;

import com.sistema.api.model.Energia;
import com.sistema.api.repository.EnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnergiaService {
    @Autowired
    private EnergiaRepository energiaRepository;

    public EnergiaService(EnergiaRepository energiaRepository) {
        this.energiaRepository = energiaRepository;
    }

    @Transactional
    public List<Object[]> getProduccionTotalPorTipoYAnio(String anio) {
        return energiaRepository.getProduccionTotalPorTipoYAnio(anio);
    }

    @Transactional
    public List<Object[]> getTop10PaisesProduccionEolica(String anio) {
        return energiaRepository.getTop10PaisesProduccionEolica(anio);
    }

    @Transactional
    public List<Float> getPorcentajeEnergiaRenovablePorRegion(String anio) {
        return energiaRepository.getPorcentajeEnergiaRenovablePorRegion(anio);
    }

    @Transactional
    public List<Object[]> getTendenciaEnergíaSolar() {
        return energiaRepository.getTendenciaEnergiaSolar();
    }

    @Transactional
    public Energia guardarEnergia(Energia energia) {
        return energiaRepository.save(energia);
    }

    @Transactional
    public List<Object[]> getEnergyEfficiency(){
        return  energiaRepository.getEnergyEfficiency();
    }

}
