package com.LojaVirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
