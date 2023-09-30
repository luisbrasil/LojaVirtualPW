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

import com.LojaVirtual.entities.CarrinhoCompra;
import com.LojaVirtual.services.CarrinhoCompraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carrinhoCompra")
@CrossOrigin
public class CarrinhoCompraController {

    @Autowired
    private CarrinhoCompraService carrinhoCompraService;

    @GetMapping()
    public List<CarrinhoCompra> buscarTodos() {
        return carrinhoCompraService.buscarTodos();
    }

    @PostMapping()
    public CarrinhoCompra inserir(@Valid @RequestBody CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraService.inserir(carrinhoCompra);
    }

    @PutMapping()
    public CarrinhoCompra alterar(@Valid @RequestBody CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraService.alterar(carrinhoCompra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        try {
            carrinhoCompraService.excluir(id);
            return ResponseEntity.ok("Carrinho de Compras excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoCompra> buscarPorId(@PathVariable("id") Long id) {

        return ResponseEntity.ok(carrinhoCompraService.buscarPorId(id));
    }

}