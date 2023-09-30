package com.LojaVirtual.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "carrinho_compra_produto")
@Data
@EqualsAndHashCode(callSuper = false)
public class CarrinhoCompraProduto extends EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;
    private double quantidade;
    private String observacao;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_carrinho_compra")
    private CarrinhoCompra carrinhoCompra;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
}