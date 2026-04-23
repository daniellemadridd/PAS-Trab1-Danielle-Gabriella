package br.pucrs.daniellemadrid.demo;

import java.util.Date;

public class Cliente {
private String cpf, nome, email, username, password;
private Date nascimento;


    public Cliente(String cpf, String nome, String email, String username, String password, Date nascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.nascimento = nascimento;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}