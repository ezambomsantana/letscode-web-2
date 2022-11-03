package com.letscode.escola.controller;

import com.letscode.escola.modelo.Aluno;
import com.letscode.escola.modelo.Turma;
import com.letscode.escola.repository.TurmaRepository;
import com.letscode.escola.service.AlunoService;
import com.letscode.escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> listaTurmas() {
        return turmaService.listarTurmas();
    }

    @PostMapping
    public String cadastrarTurma(@RequestBody Turma turma) {
        boolean cadastrou = turmaService.salvarTurma(turma);
        if (cadastrou) {
            return "Turma cadastrada com sucesso";
        }
        return "Erro no cadastro de turma";
    }

    @DeleteMapping("/{codigo}")
    public String excluirTurma(@PathVariable String codigo) {
        boolean deletou = turmaService.excluirTurma(codigo);
        if (deletou) {
            return "Turma removida com sucesso";
        }
        return "Turma nao encontrada";
    }

}
