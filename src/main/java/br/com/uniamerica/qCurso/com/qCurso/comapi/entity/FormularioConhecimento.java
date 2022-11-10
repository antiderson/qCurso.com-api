package br.com.uniamerica.qCurso.com.qCurso.comapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "tb_formularioConhecimento", schema = "public")
public class FormularioConhecimento extends AbstractEntity{


    @Getter @Setter
    @Column(name= "enunciado" , nullable = false, length = 100)
    private String enunciado;
    @Getter @Setter
    @Column(name= "resposta" , nullable = false, length = 100)
    private String resposta;
}
