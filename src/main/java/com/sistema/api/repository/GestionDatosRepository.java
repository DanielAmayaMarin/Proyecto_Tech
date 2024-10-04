package com.sistema.api.repository;

import com.sistema.api.model.GestionDatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionDatosRepository extends JpaRepository<GestionDatos, Integer> {
}
