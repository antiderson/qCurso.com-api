package br.com.uniamerica.qCurso.com.qCurso.comapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Getter @Setter
    private LocalDateTime cadastrado;
    @Getter @Setter
    private LocalDateTime atualizado;
    @Getter @Setter
    private boolean ativo;
}
