package br.com.uniamerica.qCurso.com.qCurso.comapi.repository;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    public List<Questao> findByAtivo(@Param("ativo") final boolean ativo);
    public List<Questao> findAllById(@Param("id") final Long id);
//    public List<Questao> findByLinguagem(@Param("linguagem") final boolean linguagem);
//    public List<Questao> findByDificuldade(@Param("dificuldade") final boolean dificuldade);
}
