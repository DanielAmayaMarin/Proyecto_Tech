package com.sistema.api.service;

import com.sistema.api.model.GestionDatos;
import com.sistema.api.repository.GestionDatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GestionDatosService {
    @Autowired
    private GestionDatosRepository gestionDatosRepository;

    public List<GestionDatos> obtenerTodosGestionDatos() {
        return gestionDatosRepository.findAll();
    }

    public GestionDatos guardarGestionDatos(GestionDatos gestionDatos) {
        return gestionDatosRepository.save(gestionDatos);
    }
}
