package com.LojaVirtual.services;

import java.util.NoSuchElementException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entities.Permissao;
import com.LojaVirtual.repositories.PermissaoRepository;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public Page<Permissao> buscarTodos(Pageable pageable) {
        return permissaoRepository.findAll(pageable);
    }

    public Permissao buscarPorId(Long id) {
        return permissaoRepository.findById(id).get();
    }

    public Permissao inserir(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        Permissao permissaoNovo = permissaoRepository.saveAndFlush(permissao);
        return permissaoNovo;
    }

    public Permissao alterar(Permissao permissao) {
        permissao.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public void excluir(Long id) {
        Permissao permissao = permissaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permissão não encontrada."));
        permissaoRepository.delete(permissao);
    }
}
