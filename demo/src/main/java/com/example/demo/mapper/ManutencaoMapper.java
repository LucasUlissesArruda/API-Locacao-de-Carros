package com.example.demo.mapper;

import com.example.demo.Entities.Manutencao;
import com.example.demo.dto.ManutencaoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManutencaoMapper {

    ManutencaoDTO toDTO(Manutencao manutencao);

    Manutencao toEntity(ManutencaoDTO manutencaoDTO);

    List<ManutencaoDTO> toDTOList(List<Manutencao> manutencoes);
}