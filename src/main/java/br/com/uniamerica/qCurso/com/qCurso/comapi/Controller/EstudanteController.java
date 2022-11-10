package br.com.uniamerica.qCurso.com.qCurso.comapi.Controller;


import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;


    @GetMapping
    public ResponseEntity<List<Estudante>> findAll(){
        return ResponseEntity.ok().body(this.estudanteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable final  Long id   ){
        try{
            List<Estudante> estudante = this.estudanteService.getById(id);
            return ResponseEntity.ok().body(estudante);

        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Estudante estudante){

        try {
            this.estudanteService.cadastrar(estudante);
            return ResponseEntity.ok().body("estudante cadastrado com sucesso");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


//    @PutMapping("/{id")
//    public ResponseEntity<?> atualizar(
//            @PathVariable final Long id,
//            @RequestBody final Estudante estudante
//    ){
//        try {
//            this.estudanteService.atualizar(id, estudante);
//            return ResponseEntity.ok().body("Estudante atualizado com sucesso");
//        }
//        catch (Exception e) {
//            return ResponseEntity.badRequest().body(e. getMessage());
//        }
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Estudante estudante
    ){
        try{
            this.estudanteService.excluir(id, estudante);
            return ResponseEntity.ok().body("Registro excluído com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }






}
