package com.letscode.emprestimo.service;

import com.letscode.emprestimo.modelo.Cliente;
import com.letscode.emprestimo.modelo.Emprestimo;
import com.letscode.emprestimo.modelo.Parcela;
import com.letscode.emprestimo.repository.ClienteRepository;
import com.letscode.emprestimo.repository.EmprestimoRepository;
import com.letscode.emprestimo.repository.ParcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ParcelaRepository parcelaRepository;

    public boolean salvar(Emprestimo emprestimo) {
        List<Cliente> clientes = new ArrayList<>();
        for (Cliente cliente : emprestimo.getClientes()) {
            Cliente clienteDB = clienteRepository.findByCpf(cliente.getCpf());
            if (clienteDB == null) {
                return false;
            }
            clientes.add(clienteDB);
        }
        emprestimo.setClientes(clientes);
        emprestimo = emprestimoRepository.save(emprestimo);

        for (int i  = 0; i < emprestimo.getNumeroParcelas(); i++) {
            Parcela parcela = new Parcela();
            parcela.setEmprestimo(emprestimo);
            parcela.setNum(i + 1);
            parcela.setDataVencimento(LocalDateTime.now().plusDays(30 * parcela.getNum()));
            parcela.setValor(emprestimo.getValor() / emprestimo.getNumeroParcelas());
            parcelaRepository.save(parcela);
        }

        return true;
    }

    public List<Emprestimo> listar() {
        return emprestimoRepository.findAll();
    }

}
