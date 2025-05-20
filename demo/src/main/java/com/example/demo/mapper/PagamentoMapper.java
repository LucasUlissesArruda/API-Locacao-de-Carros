package com.example.demo.mapper;

import com.example.demo.Entities.Pagamento;
import com.example.demo.dto.PagamentoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    PagamentoDTO toDTO(Pagamento pagamento);

    Pagamento toEntity(PagamentoDTO pagamentoDTO);

    List<PagamentoDTO> toDTOList(List<Pagamento> pagamentos);
}