package com.LojaVirtual.controllers;

import java.util.List;
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

import com.LojaVirtual.entities.Marca;
import com.LojaVirtual.services.MarcaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping()
    public Page<Marca> buscarTodos(Pageable pageable) {
        return marcaService.buscarTodos(pageable);
    }

    @PostMapping()
    public Marca inserir(@Valid @RequestBody Marca marca) {
        return marcaService.inserir(marca);
    }

    @PutMapping()
    public Marca alterar(@Valid @RequestBody Marca marca) {
        return marcaService.alterar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        try {
            marcaService.excluir(id);
            return ResponseEntity.ok("Marca excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable("id") Long id) {

        return ResponseEntity.ok(marcaService.buscarPorId(id));
    }

}