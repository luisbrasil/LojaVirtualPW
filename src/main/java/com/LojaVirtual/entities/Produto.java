package com.LojaVirtual.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode(callSuper = false)
public class Produto extends EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descricaoCurta;
    private String descricaoDetalhada;
    private double valorCusto;
    private double valorVenda;


    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Marca marca;

    @ManyToMany
    private List<CarrinhoCompra> carrinhoCompra;
}
