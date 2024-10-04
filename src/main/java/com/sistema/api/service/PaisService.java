package com.sistema.api.service;

import com.sistema.api.model.Pais;
import com.sistema.api.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> obtenerTodosPaises() {
        return paisRepository.findAll();
    }

    public Pais guardarPais(Pais pais) {
        return paisRepository.save(pais);
    }
}
