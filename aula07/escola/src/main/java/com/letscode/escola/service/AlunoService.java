package com.letscode.escola.service;

import com.letscode.escola.modelo.Aluno;
import com.letscode.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> buscarAlunos(String cidade) {
        if (cidade != null) {
            // select * from alunos where endereco = 'SP'
            return alunoRepository.findByEndereco(cidade);
        } else {
            //select * from alunos
            return alunoRepository.findAll();
        }
    }

    public Aluno buscaAlunoCpf(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    public boolean excluirAluno(String cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf);
        if (aluno != null) {
            alunoRepository.delete(aluno);
            return true;
        }
        return false;
    }

    public boolean atualizarAluno(String cpf, Aluno aluno) {
        Aluno alunoDB = alunoRepository.findByCpf(cpf);
        if (aluno != null) {
            alunoDB.setNome(aluno.getNome());
            alunoDB.setEndereco(aluno.getEndereco());
            alunoRepository.save(alunoDB);
            return true;
        }
        return false;
    }
}
