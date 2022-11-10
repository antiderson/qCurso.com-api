package br.com.uniamerica.qCurso.com.qCurso.comapi.repository;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Resolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResolucaoRepository extends JpaRepository<Resolucao, Long> {

    public List<Resolucao> findByAtivo(@Param("ativo") final boolean ativo);
    public List<Resolucao> findAllById(@Param("id") final long id);

//    @Query("from resolucao where resolucao.questao.id = :questaoId")
//    public List<Resolucao> findByQuestao(@Param("questao") final String questao);
}
