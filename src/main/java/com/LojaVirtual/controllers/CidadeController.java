package com.LojaVirtual.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/cidade")
@CrossOrigin
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping()
    public List<Cidade> buscarTodos() {
        return cidadeService.buscarTodos();
    }

    @PostMapping()
    public Cidade inserir(@RequestBody Cidade cidade) {
        return cidadeService.inserir(cidade);
    }

    @PutMapping()
    public Cidade alterar(@RequestBody Cidade cidade) {
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