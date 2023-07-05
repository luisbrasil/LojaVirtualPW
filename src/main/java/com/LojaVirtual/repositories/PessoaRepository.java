package com.LojaVirtual.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByCidade(long id);
}
