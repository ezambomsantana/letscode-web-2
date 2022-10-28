package com.letscode.escola.repository;

import com.letscode.escola.modelo.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    Turma findByCodigo(String codigo);

}
