package com.example.demo.controller;

<<<<<<< Updated upstream
import com.example.demo.dto.PagamentoDTO;
=======

>>>>>>> Stashed changes
import com.example.demo.service.PagamentoService;
import com.example.demo.service.Utils.ApiResponse;
import com.example.demo.service.Utils.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Pagamentos", description = "Endpoints para gerenciamento de pagamentos")
@RestController
@RequestMapping("api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Operation(summary = "Lista todos os pagamentos", description = "Retorna uma lista com todos os pagamentos registrados")
    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> listarPagamentos() {
        List<PagamentoDTO> pagamentos = pagamentoService.listarTodos();
        return ResponseEntity.ok(pagamentos);
    }

    @Operation(summary = "Busca um pagamento por ID", description = "Retorna os detalhes de um pagamento específico")
    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscarPorId(@PathVariable Long id) {
        Optional<PagamentoDTO> pagamentoDTO = pagamentoService.buscarPorId(id);
        return pagamentoDTO.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registra um novo pagamento", description = "Adiciona um novo pagamento ao sistema")
    @PostMapping
    public ResponseEntity<ApiResponse<PagamentoDTO>> criarPagamento(@Valid @RequestBody PagamentoDTO pagamentoDTO) {
        try {
            PagamentoDTO salvo = pagamentoService.salvar(pagamentoDTO);
            ApiResponse<PagamentoDTO> response = new ApiResponse<>(salvo);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            ErrorResponse error = new ErrorResponse("Argumento inválido", e.getMessage());
            return ResponseEntity.badRequest().body(new ApiResponse<>(error));
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse("Erro interno", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(error));
        }
    }

    @Operation(summary = "Deleta um pagamento", description = "Remove um pagamento do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        pagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}