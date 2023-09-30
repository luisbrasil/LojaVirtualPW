package com.LojaVirtual.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cidade")
@Data
@EqualsAndHashCode(callSuper = false)
public class Cidade extends EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
}
