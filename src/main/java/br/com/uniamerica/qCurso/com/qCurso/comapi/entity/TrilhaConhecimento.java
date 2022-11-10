package br.com.uniamerica.qCurso.com.qCurso.comapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_trilhaConhecimento", schema = "public")
public class TrilhaConhecimento extends AbstractEntity {


    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Estudante Estudante;
    @Getter @Setter
    @OneToMany(fetch = FetchType.EAGER)
    private List<FormularioConhecimento> formularioConhecimento;
}