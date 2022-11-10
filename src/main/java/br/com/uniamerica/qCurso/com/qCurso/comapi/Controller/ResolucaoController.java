package br.com.uniamerica.qCurso.com.qCurso.comapi.Controller;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Resolucao;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.EstudanteRepository;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.ResolucaoRepository;
import br.com.uniamerica.qCurso.com.qCurso.comapi.service.EstudanteService;
import br.com.uniamerica.qCurso.com.qCurso.comapi.service.ResolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/resolucao")
public class ResolucaoController {

    @Autowired
    private ResolucaoRepository resolucaoRepository;
    @Autowired
    private ResolucaoService resolucaoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.resolucaoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resolucao> findAllId(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.resolucaoRepository.findById(id).orElse(new Resolucao()));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Resolucao resolucao) {
        this.resolucaoRepository.save(resolucao);
        return ResponseEntity.ok().body("Resolucão cadastrada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Resolucao resolucao
    ){
        try {
            this.resolucaoService.atualizar(id, resolucao);
            return ResponseEntity.ok().body("Resolução atualizada com sucesso");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e. getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Resolucao resolucao
    ) {
        try {
            this.resolucaoService.excluir(id,resolucao);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Resolução deletada com sucesso");
    }
}
