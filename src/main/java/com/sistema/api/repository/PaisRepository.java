package com.sistema.api.repository;

import com.sistema.api.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, String> {

    @Procedure(name="GetPaises")
    List<Object[]> obtenerPaises();
}
