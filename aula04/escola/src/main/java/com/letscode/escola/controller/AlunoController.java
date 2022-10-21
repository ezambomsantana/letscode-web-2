package com.letscode.escola.controller;

import com.letscode.escola.modelo.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private static List<Aluno> alunos = new ArrayList<>();

    // alunos?cidade=SP
    @GetMapping
    public List<Aluno> getAlunos(
            @RequestParam(name = "cidade", required = false) String cidade) {

       if (cidade != null) {
            List<Aluno> lista = new ArrayList<>();

            for (Aluno aluno : alunos) {
                if (aluno.getEndereco().equals(cidade)) {
                    lista.add(aluno);
                }
            }
            return lista;
        } else {
            return alunos;
        }
    }

    //localhost:8080/alunos/123
    @GetMapping("/{cpf}")
    public Aluno getAluno(@PathVariable String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }


    @PostMapping
    public String salvarAlunos(@RequestBody Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().equals("")) {
            return "O nome do usuário é obrigatório";
        }

        if (aluno.getCpf() == null || aluno.getCpf().equals("")) {
            return "O CPF é obrigatório";
        }

        for (Aluno a : alunos) {
            if (a.getCpf().equals(aluno.getCpf())) {
                return "CPF já está cadastrado";
            }
        }

        alunos.add(aluno);
        return "Cadastro efetuado com sucesso!";
    }

    // localhost:8080/alunos/123
    @DeleteMapping("/{cpf}")
    public String deletarAlunos(@PathVariable String cpf) {

        Aluno alunoRemover = null;
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                alunoRemover = aluno;
            }
        }
        if (alunoRemover != null) {
            alunos.remove(alunoRemover);
            return "Aluno removido com sucesso";
        } else {
            return "Aluno não encontrado";
        }

    }



    public static boolean verificarAlunosExiste(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }


}
