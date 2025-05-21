package com.example.demo.service;

import com.example.demo.Entities.Manutencao;
import com.example.demo.dto.ManutencaoDTO;
import com.example.demo.mapper.ManutencaoMapper;
import com.example.demo.repository.IManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService {

    @Autowired
    private IManutencaoRepository manutencaoRepository;

    @Autowired
    private ManutencaoMapper manutencaoMapper;

    public List<ManutencaoDTO> listarTodos() {
        List<Manutencao> manutencoes = manutencaoRepository.findAll();
        return manutencaoMapper.toDTOList(manutencoes);
    }

    public Optional<ManutencaoDTO> buscarPorId(Long id) {
        return manutencaoRepository.findById(id)
                .map(manutencaoMapper::toDTO);
    }

    public ManutencaoDTO salvar(ManutencaoDTO manutencaoDTO) {
        Manutencao manutencao = manutencaoMapper.toEntity(manutencaoDTO);
        Manutencao salva = manutencaoRepository.save(manutencao);
        return manutencaoMapper.toDTO(salva);
    }

    public void deletar(Long id) {
        manutencaoRepository.deleteById(id);
    }
}