package com.LojaVirtual.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "estado")
@Data
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String nome;
    public String sigla;
    public Date dataCriacao;
    public Date dataAtualizacao;
}
