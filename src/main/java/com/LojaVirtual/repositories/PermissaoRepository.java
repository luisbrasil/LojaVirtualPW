package com.LojaVirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
}
