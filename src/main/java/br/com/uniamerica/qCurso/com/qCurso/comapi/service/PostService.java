package br.com.uniamerica.qCurso.com.qCurso.comapi.service;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Post;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public Post findById(Long id){
        return this.postRepository.findById(id).orElse(new Post());
    }

    public List<Post> listAll() {
        return this.postRepository.findAll();
    }

    @Transactional
    public Post save(Post post){
        return this.postRepository.save(post);
    }

    @Transactional
    public void atualizar (final Long id, final @NotNull Post post){
        if (id.equals(post.getId()) && !this.postRepository.findById(id).isEmpty()){
            this.postRepository.save(post);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void excluir(final Long id, final @NotNull Post post){
        if (id.equals(post.getId()) && !this.postRepository.findById(id).isEmpty()){
            this.postRepository.delete(post);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}
