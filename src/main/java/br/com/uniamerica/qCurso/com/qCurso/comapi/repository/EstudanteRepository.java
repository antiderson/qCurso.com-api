package br.com.uniamerica.qCurso.com.qCurso.comapi.repository;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    @Query("from Estudante where id=: id")
    public Estudante findById();

    @Query("from Estudante where ativo =: ativo")
    public List<Estudante> findByAtivoTrue();

    @Query("from Estudante where nome =: nome")
    public List<Estudante> findByNome(final String nome);
}

//    public List<Estudante> findByAtivoTrue();
//
//    public List<Estudante> findAllById(@Param("id") final Long id);

    //public List<Estudante> findByIdAtivoTrue(@Param("id")final Long id);

  //  public List<Estudante> findByNome(@Param("nome") final String nome);

