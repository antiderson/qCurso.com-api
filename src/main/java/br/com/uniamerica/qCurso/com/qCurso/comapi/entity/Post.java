package br.com.uniamerica.qCurso.com.qCurso.comapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_post", schema = "public")
public class Post extends AbstractEntity implements Serializable {

//    @Id
    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Estudante estudante;
    @Getter @Setter
    @Column(name= "descricao", nullable = false, length = 255)
    private String descricao;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Linguagem linguagem; //mudar a nomenclatura
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatusPost status;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
