package com.LojaVirtual.services;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entities.Pessoa;
import com.LojaVirtual.repositories.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).get();
    }

    public Pessoa inserir(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;
    }

    public Pessoa alterar(Pessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}
