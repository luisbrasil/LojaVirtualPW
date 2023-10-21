package com.LojaVirtual.controllers;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.LojaVirtual.entities.ProdutoNotificacao;

@Controller
public class ProdutoWebSocketController {
    
    @SendTo("produto/novo-produto")
    public ProdutoNotificacao notificarProduto(ProdutoNotificacao notificacao){
        return notificacao;
    }
}
