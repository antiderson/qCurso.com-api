package br.com.uniamerica.qCurso.com.qCurso.comapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_questao", schema = "public")
public class Questao extends AbstractEntity implements Serializable {
//    @Id

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Dificuldade Dificuldade;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Linguagem Linguagem;
    @Getter @Setter
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Getter @Setter
    @Column(name = "enunciado", nullable = false, length = 50)
    private String enunciado;
    @Getter @Setter
    @Column(name = "resposta", nullable = false, length = 255)
    private String resposta;
    @Getter @Setter
    @OneToOne(fetch = FetchType.EAGER)
    private Resolucao Resolucao;
}