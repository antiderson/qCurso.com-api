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
@Table(name ="tb_resolucao", schema = "public")
//public class Resolucao implements Serializable {

public class Resolucao extends AbstractEntity {


//    @Id
    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
//    @OneToOne (cascade = CascadeType.MERGE)
//    @PrimaryKeyJoinColumn
    private Questao Questao;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Getter @Setter
    @Column(name = "resposta" , nullable = false, length = 255)
    private String resposta;

}
