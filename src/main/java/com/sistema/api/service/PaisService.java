package com.sistema.api.service;

import com.sistema.api.dto.PaisDTO;
import com.sistema.api.dto.ProduccionRegionalDTO;
import com.sistema.api.model.Pais;
import com.sistema.api.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional()
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<PaisDTO> obtenerTodosPaises() {
        List<Object[]> resultados = paisRepository.obtenerPaises();
        return resultados.stream()
                .map(resultado -> new PaisDTO(
                        (String) resultado[0],
                        (Long) resultado[1],
                        (Float) resultado[2],
                        (String) resultado[3]
                ))
                .collect(Collectors.toList());
    }

    public Pais guardarPais(Pais pais) {
        return paisRepository.save(pais);
    }
}
