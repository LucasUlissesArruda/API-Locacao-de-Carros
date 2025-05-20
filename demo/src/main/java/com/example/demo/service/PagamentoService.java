package com.example.demo.service;

import com.example.demo.Entities.Pagamento;
import com.example.demo.dto.PagamentoDTO;
import com.example.demo.mapper.PagamentoMapper;
import com.example.demo.repository.IPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private IPagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoMapper pagamentoMapper;

    public List<PagamentoDTO> listarTodos() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        return pagamentoMapper.toDTOList(pagamentos);
    }

    public Optional<PagamentoDTO> buscarPorId(Long id) {
        return pagamentoRepository.findById(id)
                .map(pagamentoMapper::toDTO);
    }

    public PagamentoDTO salvar(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = pagamentoMapper.toEntity(pagamentoDTO);
        Pagamento salvo = pagamentoRepository.save(pagamento);
        return pagamentoMapper.toDTO(salvo);
    }

    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }
}