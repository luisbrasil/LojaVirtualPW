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

import com.LojaVirtual.entities.Permissao;
import com.LojaVirtual.services.PermissaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/permissao")
@CrossOrigin
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping()
    public Page<Permissao> buscarTodos(Pageable pageable) {
        return permissaoService.buscarTodos(pageable);
    }

    @PostMapping()
    public Permissao inserir(@Valid @RequestBody Permissao permissao) {
        return permissaoService.inserir(permissao);
    }

    @PutMapping()
    public Permissao alterar(@Valid @RequestBody Permissao permissao) {
        return permissaoService.alterar(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        try {
            permissaoService.excluir(id);
            return ResponseEntity.ok("Permissão excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permissao> buscarPorId(@PathVariable("id") Long id) {

        return ResponseEntity.ok(permissaoService.buscarPorId(id));
    }

}