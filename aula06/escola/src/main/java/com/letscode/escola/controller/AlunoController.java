package com.letscode.escola.controller;

import com.letscode.escola.modelo.Aluno;
import com.letscode.escola.repository.AlunoRepository;
import com.letscode.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // alunos?cidade=SP
    @GetMapping
    public List<Aluno> getAlunos(
            @RequestParam(name = "cidade", required = false) String cidade) {
        // buscaAlunos
        return alunoService.buscarAlunos(cidade);
    }

    //localhost:8080/alunos/123
    @GetMapping("/{cpf}")
    public Aluno getAluno(@PathVariable String cpf) {
        return alunoService.buscaAlunoCpf(cpf);
    }


    @PostMapping
    public String salvarAlunos(@RequestBody Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().equals("")) {
            return "O nome do usuário é obrigatório";
        }

        if (aluno.getCpf() == null || aluno.getCpf().equals("")) {
            return "O CPF é obrigatório";
        }

        Aluno alunoDB = alunoService.buscaAlunoCpf(aluno.getCpf());
        if (alunoDB != null) {
            return "CPF já cadastrado.";
        }

        alunoService.salvarAluno(aluno);
        return "Cadastro efetuado com sucesso!";
    }

    // localhost:8080/alunos/123
    @DeleteMapping("/{cpf}")
    public String deletarAlunos(@PathVariable String cpf) {
        boolean deletou = alunoService.excluirAluno(cpf);
        if (deletou) {
            return "Aluno excluído com sucesso!";
        }
        return "Aluno não encontrado.";
    }

    @PutMapping("/{cpf}")
    public String atualizarAluno(@PathVariable String cpf, @RequestBody Aluno aluno) {
        boolean atualizou = alunoService.atualizarAluno(cpf, aluno);
        if (atualizou) {
            return "Aluno atualizado com sucesso";
        }
        return "Aluno não encontrado";
    }

}
