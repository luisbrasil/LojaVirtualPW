package com.LojaVirtual.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "estado") 
@Data
@EqualsAndHashCode(callSuper = false)
public class Estado extends EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String nome;
    public String sigla;
}
