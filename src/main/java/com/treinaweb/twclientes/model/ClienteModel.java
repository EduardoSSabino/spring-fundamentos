package com.treinaweb.twclientes.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;


    @Column(nullable = false)
    private String profissao;

    public ClienteModel(){
    }

    public ClienteModel(Long id, String nome, LocalDate dataNascimento, String profissao){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteModel cliente = (ClienteModel) o;
        return id.equals(cliente.id) && nome.equals(cliente.nome) && dataNascimento.equals(cliente.dataNascimento) && profissao.equals(cliente.profissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, profissao);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", profissao='" + profissao + '\'' +
                '}';
    }
}



