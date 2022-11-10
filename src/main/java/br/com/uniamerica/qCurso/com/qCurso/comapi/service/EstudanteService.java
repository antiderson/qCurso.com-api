package br.com.uniamerica.qCurso.com.qCurso.comapi.service;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante findById(Long id) {
        return this.estudanteRepository.findById(id).orElse(new Estudante());
    }

    public List<Estudante> listAll() {
        return this.estudanteRepository.findAll();
    }

    @Transactional
    public Estudante save(Estudante estudante) {
        return this.estudanteRepository.save(estudante);
    }

    @Transactional
    public void atualizar(final Long id, final Estudante estudante) {
        if (id.equals(estudante.getId()) && !this.estudanteRepository.findById(id).isEmpty()) {
            this.estudanteRepository.save(estudante);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void excluir(final Long id, final Estudante estudante) {
        if (id.equals(estudante.getId()) && !this.estudanteRepository.findById(id).isEmpty()) {
            this.estudanteRepository.delete(estudante);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}


//    public List<Estudante> getById (Long id){
//        return this.estudanteRepository.findAllById(id);
//    }
//    public Estudante cadastrar (Estudante estudante){
//        return this.estudanteRepository.save(estudante);
//    }

//    public void atualizar (Long id, Estudante estudante){
//        this.estudanteRepository.atualizar(id, estudante.setNome(estudante.getNome()), estudante.setEmail(estudante.getEmail()), estudante.setLinkedin(estudante.getLogin()), estudante.setGithub(estudante.getGithub())
//        this.estudanteRepository.save(estudante);
//    }

//    public void excluir(final Long id, final @NotNull Estudante estudante){
//        if(id.equals(estudante.getId()) && !this.estudanteRepository.findAllById(id).isEmpty()){
//            this.estudanteRepository.delete(estudante);
//        }
//        else{
//            throw new RuntimeException("Id não encontrado");
//        }
//    }
