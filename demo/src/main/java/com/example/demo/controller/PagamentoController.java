package com.example.demo.controller;

import com.example.demo.model.Pagamento;
import com.example.demo.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento pagamento) {
        return pagamentoService.criar(pagamento);
    }

    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPorId(@PathVariable Long id) {
        return pagamentoService.buscarPorId(id);
    }

    @PatchMapping("/{id}/status")
    public Pagamento atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        return pagamentoService.atualizarStatus(id, novoStatus);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pagamentoService.deletar(id);
    }
}
