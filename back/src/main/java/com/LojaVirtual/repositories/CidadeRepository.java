package com.LojaVirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
}
