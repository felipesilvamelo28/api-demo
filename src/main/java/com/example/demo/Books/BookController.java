package com.example.demo.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Book> listar(){
        return bookRepository.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody BookDTO bookDTO){

        Book book = new Book();
        book.setNome(bookDTO.getNome());
        book.setAutor(bookDTO.getAutor());
        bookRepository.save(book);
    }

}
