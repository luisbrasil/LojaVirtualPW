package com.LojaVirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>  {
    
}
