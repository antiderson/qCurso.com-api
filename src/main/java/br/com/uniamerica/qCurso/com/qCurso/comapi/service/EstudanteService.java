package br.com.uniamerica.qCurso.com.qCurso.comapi.service;


import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;


    public List<Estudante> findAll(){
        return this.estudanteRepository.findByAtivoTrue();
    }


    public List<Estudante> getById (Long id){
        return this.estudanteRepository.findAllById(id);
    }
    public Estudante cadastrar (Estudante estudante){
        return this.estudanteRepository.save(estudante);
    }

//    public void atualizar (Long id, Estudante estudante){
//        this.estudanteRepository.atualizar(id, estudante.setNome(estudante.getNome()), estudante.setEmail(estudante.getEmail()), estudante.setLinkedin(estudante.getLogin()), estudante.setGithub(estudante.getGithub())
//        this.estudanteRepository.save(estudante);
//    }

    public void excluir(final Long id, final @NotNull Estudante estudante){
        if(id.equals(estudante.getId()) && !this.estudanteRepository.findAllById(id).isEmpty()){
            this.estudanteRepository.delete(estudante);
        }
        else{
            throw new RuntimeException("Id não encontrado");
        }
    }



}
