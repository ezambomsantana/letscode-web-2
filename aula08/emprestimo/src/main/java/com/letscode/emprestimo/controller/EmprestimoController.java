package com.letscode.emprestimo.controller;

import com.letscode.emprestimo.modelo.Emprestimo;
import com.letscode.emprestimo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    // injeção de dependencias
    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> listaEmprestimos() {
        return emprestimoService.listar();
    }

    @PostMapping
    public String cadastraEmprestimo(@RequestBody Emprestimo emprestimo) {
        if (emprestimo.getValor() == null || emprestimo.getValor() < 100) {
            return "Erro, valor do emprestimo inválido.";
        }

        if (emprestimo.getStatus() == null) {
            return "Erro, status não pode ser nulo";
        }

        if (emprestimo.getNumeroParcelas() == null || emprestimo.getNumeroParcelas() <= 0) {
            return "Erro, numero de parcelas deve ser maior que 0";
        }

        emprestimo.setDataEmprestimo(LocalDateTime.now());
        boolean cadastrou = emprestimoService.salvar(emprestimo);
        if (cadastrou) {
            return "Emprestimo cadastrado com sucesso!";
        } else {
            return "Erro, cliente não encontrado";
        }
    }

}
