package com.letscode.emprestimo.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double valor;

    private LocalDateTime dataEmprestimo;

    private String status;

    private Integer numeroParcelas;

    @ManyToMany
    @JoinTable(
            name = "emprestimo_cliente",
            joinColumns = {@JoinColumn(name = "id_emprestimo")},
            inverseJoinColumns = {@JoinColumn(name = "id_cliente")}
    )
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "emprestimo")
    private List<Parcela> parcelas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }
}
