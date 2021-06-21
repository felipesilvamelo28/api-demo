package com.example.demo.controller;

import com.example.demo.Webscrapping.DemoWebScrapping;
import com.example.demo.entity.Passing;
import com.example.demo.repository.PassingRepository;
import com.example.demo.service.PassingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/player")
public class PlayerController {

    @Autowired
    PassingRepository repository;

    @Autowired
    PassingService service;

    @GetMapping(value = "/extrair")
    public String extrair () throws IOException {
        service.extrairDados();
        return "Dados extraidos";
    }

    @GetMapping(value = "/listar")
    public List<Passing> list () throws IOException {
        System.out.println("recuperando dados do banco");
        return repository.findAll();
    }

}
