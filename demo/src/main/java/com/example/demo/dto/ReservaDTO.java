package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReservaDTO {

    private Long id;

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "O ID do carro é obrigatório")
    private Long carroId;

    @NotNull(message = "A data de início é obrigatória")
    private LocalDateTime dataInicio;

    @NotNull(message = "A data de fim é obrigatória")
    private LocalDateTime dataFim;

    @NotBlank(message = "O status da reserva é obrigatório")
    private String status;
}