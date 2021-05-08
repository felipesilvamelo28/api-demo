package com.example.demo.Books;

public class BookDTO {

    private String nome;
    private String autor;

    public BookDTO(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
    }

    public BookDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
