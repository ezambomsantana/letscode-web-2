package com.letscode.emprestimo.repository;

import com.letscode.emprestimo.modelo.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelaRepository extends JpaRepository<Parcela, Integer> {
}
