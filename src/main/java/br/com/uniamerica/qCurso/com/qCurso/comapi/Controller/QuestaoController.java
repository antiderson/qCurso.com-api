package br.com.uniamerica.qCurso.com.qCurso.comapi.Controller;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Questao;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.EstudanteRepository;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.QuestaoRepository;
import br.com.uniamerica.qCurso.com.qCurso.comapi.service.EstudanteService;
import br.com.uniamerica.qCurso.com.qCurso.comapi.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/questao")
public class QuestaoController {

    @Autowired
    private QuestaoRepository questaoRepository;
    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.questaoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> findAllId(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.questaoRepository.findById(id).orElse(new Questao()));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Questao questao) {
        this.questaoRepository.save(questao);
        return ResponseEntity.ok().body("Questão cadastrada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Questao questao
    ){
        try {
            this.questaoService.atualizar(id, questao);
            return ResponseEntity.ok().body("Questão atualizada com sucesso");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e. getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Questao questao
    ) {
        try {
            this.questaoService.excluir(id,questao);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Questão deletada com sucesso");
    }
}
