package com.letscode.escola.modelo;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String codigo;
    private String nome;
    private Integer numeroAlunos;
    private List<Aluno> alunos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumeroAlunos() {
        return numeroAlunos;
    }

    public void setNumeroAlunos(Integer numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }
}
