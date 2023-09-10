package model;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private int id;
    private String nome;

    // Construtor completo
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getter para o campo 'id'
    public int getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter para o campo 'nome'
    public String getNome() {
        return nome;
    }

    // Setter para o campo 'nome'
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para exibir os dados da pessoa
    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }
}

