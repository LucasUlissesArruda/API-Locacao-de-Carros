package com.example.demo.controller;

import com.example.demo.dto.ManutencaoDTO;
import com.example.demo.service.ManutencaoService;
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

@Tag(name = "Manutenções", description = "Endpoints para gerenciamento de manutenções")
@RestController
@RequestMapping("api/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @Operation(summary = "Lista todas as manutenções", description = "Retorna uma lista com todas as manutenções registradas")
    @GetMapping
    public ResponseEntity<List<ManutencaoDTO>> listarManutencoes() {
        List<ManutencaoDTO> manutencoes = manutencaoService.listarTodos();
        return ResponseEntity.ok(manutencoes);
    }

    @Operation(summary = "Busca uma manutenção por ID", description = "Retorna os detalhes de uma manutenção específica")
    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoDTO> buscarPorId(@PathVariable Long id) {
        Optional<ManutencaoDTO> manutencaoDTO = manutencaoService.buscarPorId(id);
        return manutencaoDTO.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registra uma nova manutenção", description = "Adiciona uma nova manutenção ao sistema")
    @PostMapping
    public ResponseEntity<ApiResponse<ManutencaoDTO>> criarManutencao(@Valid @RequestBody ManutencaoDTO manutencaoDTO) {
        try {
            ManutencaoDTO salva = manutencaoService.salvar(manutencaoDTO);
            ApiResponse<ManutencaoDTO> response = new ApiResponse<>(salva);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            ErrorResponse error = new ErrorResponse("Argumento inválido", e.getMessage());
            return ResponseEntity.badRequest().body(new ApiResponse<>(error));
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse("Erro interno", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(error));
        }
    }

    @Operation(summary = "Deleta uma manutenção", description = "Remove uma manutenção do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarManutencao(@PathVariable Long id) {
        manutencaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}