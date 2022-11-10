package br.com.uniamerica.qCurso.com.qCurso.comapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_estudante", schema = "public")
public class Estudante extends AbstractEntity implements Serializable {

//    @Id
    @Getter @Setter
    @Column(name = "login", nullable = false, length = 25, unique =  true)
    private String login;
    @Getter @Setter
    @Column(name = "senha", nullable = false, length = 25)
    private String senha;
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 25)
    private String nome;
    @Getter @Setter
    @Column(name= "github", length = 50)
    private String github;
    @Getter @Setter
    @Column(name= "linkedin", length = 25)
    private String linkedin;
    @Getter @Setter
    @Column(name= "email", nullable = false, length = 25, unique = true)
    private String email;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
