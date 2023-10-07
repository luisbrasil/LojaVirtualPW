package com.LojaVirtual.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.LojaVirtual.entities.Marca;
import com.LojaVirtual.repositories.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public Page<Marca> buscarTodos(Pageable pageable) {
        return marcaRepository.findAll(pageable);
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id).get();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca marcaNovo = marcaRepository.saveAndFlush(marca);
        return marcaNovo;
    }

    public Marca alterar(Marca marca) {
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void excluir(Long id) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Marca não encontrada."));
        marcaRepository.delete(marca);
    }
}
