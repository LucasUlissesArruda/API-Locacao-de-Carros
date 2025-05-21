package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CarroDTO {

    private Long id;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @NotNull(message = "O ano é obrigatório")
    private Integer ano;

    @NotBlank(message = "A placa é obrigatória")
    private String placa;

    @NotNull(message = "A disponibilidade é obrigatória")
    private Boolean disponivel;

    @NotNull(message = "O preço da diária é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço da diária deve ser maior que zero")
    private BigDecimal precoDiaria;
}
