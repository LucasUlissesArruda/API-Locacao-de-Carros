package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "carros")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Boolean disponivel;

    @Column(nullable = false)
    private BigDecimal precoDiaria;
}
