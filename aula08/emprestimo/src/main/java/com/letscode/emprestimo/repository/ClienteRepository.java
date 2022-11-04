package com.letscode.emprestimo.repository;

import com.letscode.emprestimo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByCpf(String cpf);

}
