package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
    
    // Consulta capaz de buscar todos os trabalhos que contenham uma palavra dentro de seu título com nota superior a um número
    public List<Trabalho> findByTituloContainsAndNotaGreaterThan(String titulo, Integer nota);
}
