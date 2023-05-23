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

import com.LojaVirtual.entities.Categoria;
import com.LojaVirtual.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public List<Categoria> buscarTodos() {
        return categoriaService.buscarTodos();
    }

    @PostMapping()
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaService.inserir(categoria);
    }

    @PutMapping()
    public Categoria alterar(@RequestBody Categoria categoria) {
        return categoriaService.alterar(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        try {
            categoriaService.excluir(id);
            return ResponseEntity.ok("Categoria excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") Long id) {

        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

}