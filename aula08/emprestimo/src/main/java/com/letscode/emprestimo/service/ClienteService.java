package com.letscode.emprestimo.service;

import com.letscode.emprestimo.modelo.Cliente;
import com.letscode.emprestimo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    
    // teste

    @Autowired
    private ClienteRepository clienteRepository;

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

}
