package com.example.demo.controller;

import com.example.demo.dto.CarroDTO;
import com.example.demo.service.CarroService;
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

@Tag(name = "Carros", description = "Endpoints para gerenciamento de carros")
@RestController
@RequestMapping("api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @Operation(summary = "Lista todos os carros", description = "Retorna uma lista com todos os carros cadastrados")
    @GetMapping
    public ResponseEntity<List<CarroDTO>> listarCarros() {
        return ResponseEntity.ok(carroService.listarTodos());
    }

    @Operation(summary = "Busca um carro por ID", description = "Retorna os detalhes de um carro específico")
    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> buscarPorId(@PathVariable Long id) {
        Optional<CarroDTO> carroDTO = carroService.buscarPorId(id);
        return carroDTO.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registra um novo carro", description = "Adiciona um novo carro ao sistema")
    @PostMapping
    public ResponseEntity<ApiResponse<CarroDTO>> criarCarro(@Valid @RequestBody CarroDTO carroDTO) {
        try {
            CarroDTO salvo = carroService.salvar(carroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(salvo));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(new ErrorResponse("Argumento inválido", e.getMessage())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(new ErrorResponse("Erro interno", e.getMessage())));
        }
    }

    @Operation(summary = "Deleta um carro", description = "Remove um carro do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
