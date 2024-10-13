package com.sistema.api.service;

import com.sistema.api.model.Energia;
import com.sistema.api.repository.EnergiaRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EnergiaService {
    @Autowired
    private static EnergiaRepository energiaRepository;
    private static EnergiaRepository EnergiaActualizada;


    public List<Object[]> getProduccionTotalPorTipoYAnio(String anio) {
        return energiaRepository.getProduccionTotalPorTipoYAnio(anio);
    }

    public List<Object[]> getTop10PaisesProduccionEolica(String anio) {
        return energiaRepository.getTop10PaisesProduccionEolica(anio);
    }

    public List<Float> getPorcentajeEnergiaRenovablePorRegion(String anio) {
        return energiaRepository.getPorcentajeEnergiaRenovablePorRegion(anio);
    }

    public List<Object[]> getTendenciaEnergíaSolar() {
        return energiaRepository.getTendenciaEnergíaSolar();
    }

    public Energia guardarEnergia(Energia energia) {
        return energiaRepository.save(energia);
    }

    public static Energia actualizarEnergia(Long id, Energia energia) {return energiaRepository.put(energia);};

    public static void eliminarEnergia(SingularAttribute<AbstractPersistable, Serializable> id) {
        energiaRepository.delete((Energia) id);
    }



}
