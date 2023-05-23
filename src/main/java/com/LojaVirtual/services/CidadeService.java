package com.LojaVirtual.services;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entities.Cidade;
import com.LojaVirtual.repositories.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos() {
        return cidadeRepository.findAll();
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
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }
}
