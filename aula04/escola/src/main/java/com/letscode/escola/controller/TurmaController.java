package com.letscode.escola.controller;

import com.letscode.escola.modelo.Aluno;
import com.letscode.escola.modelo.Turma;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private static List<Turma> turmas = new ArrayList<>();

    @GetMapping
    public List<Turma> listaTurmas() {
        return turmas;
    }

    @PostMapping
    public String cadastrarTurma(@RequestBody Turma turma) {

        for (Aluno aluno : turma.getAlunos()) {
            boolean existe = AlunoController.verificarAlunosExiste(aluno.getCpf());
            if (!existe) {
                return "Aluno nao encontrado: " + aluno.getNome();
            }
        }
        turma.setNumeroAlunos(turma.getAlunos().size());
        turmas.add(turma);
        return "Turma cadastrada com sucesso";

    }

    @DeleteMapping("/{codigo}")
    public String excluirTurma(@PathVariable String codigo) {

        Turma turmaRemover = null;
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                turmaRemover = turma;
            }
        }
        if (turmaRemover != null) {
            turmas.remove(turmaRemover);
            return "Turma removida com sucesso";
        } else {
            return "Turma nao encontrada";
        }
    }

}
