<<<<<<< HEAD:trabalho/src/main/java/com/example/Cliente.java
package com.example;
=======
package model;
>>>>>>> 6a8a55305b8e1f582d191ca580a3c0938a76fff3:trabalho/src/main/java/model/Cliente.java
public class Cliente {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String dataNascimento;

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String endereco, String telefone, String email, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String toString() {
        return "Cliente [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone
                + ", email=" + email + ", dataNascimento=" + dataNascimento + "]";
    }
}