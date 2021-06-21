package com.example.demo.service;

import com.example.demo.Webscrapping.DemoWebScrapping;
import com.example.demo.entity.Passing;
import com.example.demo.repository.PassingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PassingService {

    @Autowired
    PassingRepository repository;

    public void extrairDados() throws IOException {
        List<Passing> passers = DemoWebScrapping.extrairDados();

        for (Passing p: passers){
            System.out.println("salvando o qb " + p.getName());
            repository.save(p);
        }
    }

}
