package com.example.demo.repository;

import com.example.demo.Entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroRepository extends JpaRepository<Carro, Long> {
}
