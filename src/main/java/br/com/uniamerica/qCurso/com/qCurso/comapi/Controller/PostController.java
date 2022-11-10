package br.com.uniamerica.qCurso.com.qCurso.comapi.Controller;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Post;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.PostRepository;
import br.com.uniamerica.qCurso.com.qCurso.comapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.postRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findAllId(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.postRepository.findById(id).orElse(new Post()));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Post post) {
        this.postRepository.save(post);
        return ResponseEntity.ok().body("Post cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Post post
    ){
        try {
            this.postService.atualizar(id, post);
            return ResponseEntity.ok().body("Post atualizado com sucesso");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e. getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Post post
    ) {
        try {
            this.postService.excluir(id,post);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Post deletado com sucesso");
    }
}