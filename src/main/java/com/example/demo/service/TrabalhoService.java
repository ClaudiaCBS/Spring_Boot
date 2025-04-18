package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Trabalho;
import com.example.demo.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repo;

    // Metodo para listar todos os registros da tabela
    public List<Trabalho> buscarTodos(){

        return repo.findAll();
        
    }

    // Metodo para cadastro
    public Trabalho novo(Trabalho trabalho){

        if(trabalho.getTitulo() == null ||
            trabalho.getTitulo().isBlank() ||
            trabalho.getGrupo() == null ||
            trabalho.getGrupo().isBlank()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta título ou grupo!");
            }
        if(trabalho.getDataHoraEntrega() == null){
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }
            return repo.save(trabalho);
    }

    // Metodo para buscar usando a consulta criada no repository
    public List<Trabalho> buscarPorTituloENota(String titulo, Integer nota){
        return repo.findByTituloContainsAndNotaGreaterThan(titulo, nota);
    }
    
}
