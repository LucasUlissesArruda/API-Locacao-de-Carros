package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "manutencoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long carroId;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String status;
}