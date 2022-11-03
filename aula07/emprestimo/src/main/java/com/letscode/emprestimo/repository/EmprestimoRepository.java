package com.letscode.emprestimo.repository;

import com.letscode.emprestimo.modelo.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
