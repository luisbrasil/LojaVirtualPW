package com.LojaVirtual.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "carrinho_compra")
@Data
public class CarrinhoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date dataCompra;
    private String observacao;
    private String situacao;
    private Date dataCriacao;
    private Date dataAtualizacao;

    @ManyToMany
    private List<Pessoa> pessoas;
}
