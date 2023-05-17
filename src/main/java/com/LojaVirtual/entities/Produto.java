package com.LojaVirtual.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descricaoCurta;
    private String descricaoDetalhada;
    private double valorCusto;
    private double valorVenda;
    private Date dataCriacao;
    private Date dataAtualizacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Marca marca;

    @ManyToMany
    private List<CarrinhoCompra> carrinhoCompra;
}
