package com.example.demo.mapper;

import com.example.demo.Entities.Reserva;
import com.example.demo.dto.ReservaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaDTO toDTO(Reserva reserva);

    Reserva toEntity(ReservaDTO reservaDTO);

    List<ReservaDTO> toDTOList(List<Reserva>reservas);
}