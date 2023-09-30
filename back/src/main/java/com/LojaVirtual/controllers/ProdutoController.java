package com.LojaVirtual.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LojaVirtual.entities.Produto;
import com.LojaVirtual.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public Page<Produto> buscarTodos(Pageable pageable) {
        return produtoService.buscarTodos(pageable);
    }

    @PostMapping()
    public Produto inserir(@RequestBody Produto produto) {
        return produtoService.inserir(produto);
    }

    @PutMapping()
    public Produto alterar(@RequestBody Produto produto) {
        return produtoService.alterar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        try {
            produtoService.excluir(id);
            return ResponseEntity.ok("Produto excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable("id") Long id) {

        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

}