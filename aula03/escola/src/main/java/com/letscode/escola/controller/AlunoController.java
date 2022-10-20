package com.letscode.escola.controller;

import com.letscode.escola.modelo.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {

    private static List<Aluno> alunos = new ArrayList<>();

    // /alunos?cidade=SP
    @GetMapping("/alunos")
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
    @GetMapping("/alunos/{cpf}")
    public Aluno getAluno(@PathVariable String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }


    @PostMapping("/alunos")
    public void salvarAlunos(@RequestBody Aluno aluno) {
        alunos.add(aluno);
    }



}
