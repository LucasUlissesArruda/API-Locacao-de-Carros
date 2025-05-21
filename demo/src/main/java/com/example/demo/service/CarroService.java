package com.example.demo.service;

import com.example.demo.Entities.Carro;
import com.example.demo.dto.CarroDTO;
import com.example.demo.mapper.CarroMapper;
import com.example.demo.repository.ICarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private ICarroRepository carroRepository;

    @Autowired
    private CarroMapper carroMapper;

    public List<CarroDTO> listarTodos() {
        return carroMapper.toDTOList(carroRepository.findAll());
    }

    public Optional<CarroDTO> buscarPorId(Long id) {
        return carroRepository.findById(id).map(carroMapper::toDTO);
    }

    public CarroDTO salvar(CarroDTO carroDTO) {
        Carro carro = carroMapper.toEntity(carroDTO);
        Carro salvo = carroRepository.save(carro);
        return carroMapper.toDTO(salvo);
    }

    public void deletar(Long id) {
        carroRepository.deleteById(id);
    }
}
