package com.LojaVirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
}
