package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Trabalho;
import com.example.demo.service.TrabalhoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/trabalho")
public class TrabalhoController {

    @Autowired
    public TrabalhoService service;

    // Rota para listar todos os registros
    @GetMapping
    public List<Trabalho> buscarTrabalhos(){
        return service.buscarTodos();
    }

    // Rota para um cadastro
    @PostMapping
    public Trabalho novoTrabalho(@RequestBody Trabalho trabalho){
        return service.novo(trabalho);
    }
    
    // Rota para busca por título e nota
    @GetMapping(value = "/{titulo}/{nota}")
    public List<Trabalho> buscarTrabalhoPorTituloENota(@PathVariable("titulo") String titulo, @PathVariable("nota") Integer nota){
        return service.buscarPorTituloENota(titulo, nota);
    }
}
