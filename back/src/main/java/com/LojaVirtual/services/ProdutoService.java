package com.LojaVirtual.services;

import java.util.NoSuchElementException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entities.Produto;
import com.LojaVirtual.entities.ProdutoNotificacao;
import com.LojaVirtual.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public Page<Produto> buscarTodos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).get();
    }

    public Produto inserir(Produto produto) {
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepository.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto alterar(Produto produto) {
        produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public void excluir(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado."));
        produtoRepository.delete(produto);
    }

    private void notificar(Produto produto){
        ProdutoNotificacao notificacao = new ProdutoNotificacao();
        notificacao.setDescricao("O produto " + produto.getDescricaoCurta());
        simpMessagingTemplate
            .convertAndSend("/produto/novo-produto", notificacao);
    }
}
