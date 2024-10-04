package com.sistema.api.repository;

import com.sistema.api.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, String> {
}
