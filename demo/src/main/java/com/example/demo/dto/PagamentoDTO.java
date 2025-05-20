package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PagamentoDTO {

    private Long id;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "A data do pagamento é obrigatória")
    private LocalDateTime dataPagamento;

    @NotBlank(message = "O status é obrigatório")
    private String status;

    @NotBlank(message = "A forma de pagamento é obrigatória")
    private String formaPagamento;
}