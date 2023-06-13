package com.LojaVirtual.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "{nome.not.blank}")
    public String nome;

    @NotBlank(message = "{sigla.not.blank}")
    @Size(min = 2, max = 2)
    public String sigla;
}
