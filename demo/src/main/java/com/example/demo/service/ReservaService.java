package com.example.demo.service;

import com.example.demo.Entities.Reserva;
import com.example.demo.dto.ReservaDTO;
import com.example.demo.mapper.ReservaMapper;
import com.example.demo.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    public List<ReservaDTO> listarTodos() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservaMapper.toDTOList(reservas);
    }

    public Optional<ReservaDTO> buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toDTO);
    }

    public ReservaDTO salvar(ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        Reserva salva = reservaRepository.save(reserva);
        return reservaMapper.toDTO(salva);
    }

    public void deletar(Long id) {
        reservaRepository.deleteById(id);
    }
}