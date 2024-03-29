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

import com.LojaVirtual.entities.Cidade;
import com.LojaVirtual.services.CidadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cidade")
@CrossOrigin
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping()
    public Page<Cidade> buscarTodos(Pageable pageable) {
        return cidadeService.buscarTodos(pageable);
    }

    @PostMapping()
    public Cidade inserir(@Valid @RequestBody Cidade cidade) {
        return cidadeService.inserir(cidade);
    }

    @PutMapping()
    public Cidade alterar(@Valid @RequestBody Cidade cidade) {
        return cidadeService.alterar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        try {
            cidadeService.excluir(id);
            return ResponseEntity.ok("Cidade excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable("id") Long id) {

        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

}