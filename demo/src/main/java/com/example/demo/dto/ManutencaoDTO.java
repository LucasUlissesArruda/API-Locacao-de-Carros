package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ManutencaoDTO {

    private Long id;

    @NotNull(message = "O ID do carro é obrigatório")
    private Long carroId;

    @NotNull(message = "A data de início é obrigatória")
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "O status da manutenção é obrigatório")
    private String status;
}