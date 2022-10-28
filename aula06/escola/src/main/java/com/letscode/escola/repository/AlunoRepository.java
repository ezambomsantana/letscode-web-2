package com.letscode.escola.repository;

import com.letscode.escola.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByEndereco(String endereco);

    List<Aluno> findByNome(String nome);

    Aluno findByCpf(String cpf);

}
