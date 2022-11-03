package com.letscode.escola.service;

import com.letscode.escola.modelo.Aluno;
import com.letscode.escola.modelo.Turma;
import com.letscode.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoService alunoService;

    public boolean salvarTurma(Turma turma) {
        turma.setNumeroAlunos(turma.getAlunos().size());
        Turma turmaDB = turmaRepository.save(turma);

        for (Aluno aluno : turma.getAlunos()) {
            Aluno alunoDB = alunoService.buscaAlunoCpf(aluno.getCpf());
            if (alunoDB == null) {
                return false;
            }
            alunoDB.setTurma(turmaDB);
            alunoService.salvarAluno(alunoDB);
        }
        return true;
    }

    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    public boolean excluirTurma(String codigo) {
        Turma turma = turmaRepository.findByCodigo(codigo);
        if (turma != null) {
            turmaRepository.delete(turma);
            return true;
        } else {
            return false;
        }
    }

}
