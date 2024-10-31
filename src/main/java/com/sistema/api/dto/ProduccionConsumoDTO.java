package com.sistema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduccionConsumoDTO {
    private Integer anio;
    private Integer mes;
    private Double produccion;
    private Double consumo;
}
