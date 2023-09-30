package com.LojaVirtual.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entities.CarrinhoCompra;
import com.LojaVirtual.repositories.CarrinhoCompraRepository;

@Service
public class CarrinhoCompraService {

    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    public List<CarrinhoCompra> buscarTodos() {
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra buscarPorId(Long id) {
        return carrinhoCompraRepository.findById(id).get();
    }

    public CarrinhoCompra inserir(CarrinhoCompra carrinhoCompra) {
        carrinhoCompra.setDataCriacao(new Date());
        CarrinhoCompra carrinhoCompraNovo = carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
        return carrinhoCompraNovo;
    }

    public CarrinhoCompra alterar(CarrinhoCompra carrinhoCompra) {
        carrinhoCompra.setDataAtualizacao(new Date());
        return carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
    }

    public void excluir(Long id) {
        CarrinhoCompra carrinhoCompra = carrinhoCompraRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Carrinho de Compras não encontrado."));
        carrinhoCompraRepository.delete(carrinhoCompra);
    }
}
