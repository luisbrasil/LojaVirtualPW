package com.LojaVirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
