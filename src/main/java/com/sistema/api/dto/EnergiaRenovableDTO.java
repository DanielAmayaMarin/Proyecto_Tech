package com.sistema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnergiaRenovableDTO {
    private String tipoEnergia;
    private Double cantidad;
    private Double porcentaje;
}
