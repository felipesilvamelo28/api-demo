package com.example.demo.controller;

import com.example.demo.entity.Aluno;
import com.example.demo.entity.Passing;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.PassingRepository;
import com.example.demo.service.PassingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @GetMapping
    public List<Aluno> list (){
        System.out.println("recuperando os alunos");
        return repository.findAll();
    }

    @PostMapping
    public void salvar (@RequestBody Aluno aluno){
        System.out.println("salvando aluno " + aluno.getName());
        repository.save(aluno);
    }

}
