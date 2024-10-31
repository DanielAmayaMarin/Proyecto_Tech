package com.sistema.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduccionRegionalDTO {
    private String region;
    private Double consumoTotal;
    private Double consumoRenovable;
    private Double porcentajeRenovable;
}
