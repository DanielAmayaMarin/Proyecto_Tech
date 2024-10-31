package com.sistema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopProductoresEolicosDTO {
    private String pais;
    private Double produccionEolica;
    private Double capacidadInstalada;
    private Double porcentajeTotal;

}
