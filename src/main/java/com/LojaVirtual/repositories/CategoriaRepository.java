package com.LojaVirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
