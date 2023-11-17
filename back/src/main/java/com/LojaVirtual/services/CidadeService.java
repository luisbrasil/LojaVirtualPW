package com.LojaVirtual.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entities.Cidade;
import com.LojaVirtual.repositories.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Page<Cidade> buscarTodos(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).get();
    }

    public Cidade inserir(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(cidade);
        return cidadeNovo;
    }

    public Cidade alterar(Cidade cidade) {
        cidade.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public void excluir(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cidade não encontrada."));
        cidadeRepository.delete(cidade);
    }
}
