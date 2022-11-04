package com.letscode.emprestimo.controller;

import com.letscode.emprestimo.modelo.Cliente;
import com.letscode.emprestimo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listar();
    }

    @PostMapping
    public String cadastraClientes(@RequestBody Cliente cliente) {

        if (cliente.getCpf() == null) {
            return "CPF é obrigatório";
        }

        if (cliente.getNome() == null) {
            return "Nome é obrigatório";
        }

        if (cliente.getSalario() == null || cliente.getSalario() <= 0) {
            return "O salário deve ser maior que 0";
        }

        clienteService.salvarCliente(cliente);
        return "Cliente cadastrado com sucesso";

    }

}
