package com.LojaVirtual.entities;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "carrinho_compra")
@Data
@EqualsAndHashCode(callSuper = false)
public class CarrinhoCompra extends EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "{data.not.blank}")
    private Date dataCompra;

    private String observacao;

    @NotBlank(message = "{situacao.not.blank}")
    private String situacao;

    @ManyToOne
    private Pessoa pessoa;

    @OneToMany
    private List<Produto> produtos;
}
