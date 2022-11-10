package br.com.uniamerica.qCurso.com.qCurso.comapi.repository;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> findAllById(@Param("id") final Long id);
    public List<Post> findByAtivo(@Param("ativo") final boolean ativo);

//    public List<Post> findByLinguagem(@Param("linguagem")final String linguagem);
//
//    public List<Post> findByDificuldade(@Param("dificuldade") final String dificuldade);
}
