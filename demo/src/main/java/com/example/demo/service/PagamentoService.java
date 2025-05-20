package com.example.demo.service;

import com.example.demo.model.Pagamento;
import com.example.demo.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento criar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento buscarPorId(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Pagamento atualizarStatus(Long id, String novoStatus) {
        Pagamento pagamento = buscarPorId(id);
        if (pagamento != null) {
            pagamento.setStatus(novoStatus);
            return pagamentoRepository.save(pagamento);
        }
        return null;
    }

    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
