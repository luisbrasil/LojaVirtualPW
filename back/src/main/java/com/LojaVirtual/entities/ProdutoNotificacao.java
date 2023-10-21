package com.LojaVirtual.entities;

import java.util.Date;

import lombok.Data;

@Data
public class ProdutoNotificacao {
    private String descricao;
    private Date dataNotificacao = new Date();
}
