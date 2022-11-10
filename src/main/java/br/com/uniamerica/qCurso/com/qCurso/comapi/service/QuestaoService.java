package br.com.uniamerica.qCurso.com.qCurso.comapi.service;

import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Questao;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.EstudanteRepository;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestaoService {


    @Autowired
    private QuestaoRepository questaoRepository;

    public Questao findById(Long id) {
        return this.questaoRepository.findById(id).orElse(new Questao());
    }

    public List<Questao> listAll() {
        return this.questaoRepository.findAll();
    }

    @Transactional
    public Questao save(Questao questao) {
        return this.questaoRepository.save(questao);
    }

    @Transactional
    public void atualizar(final Long id, final Questao questao) {
        if (id.equals(questao.getId()) && !this.questaoRepository.findById(id).isEmpty()) {
            this.questaoRepository.save(questao);
        } else {
            throw new RuntimeException("Questão não encontrada");
        }
    }
        @Transactional
        public void excluir(final Long id, final Questao questao) {
            if (id.equals(questao.getId()) && !this.questaoRepository.findById(id).isEmpty()) {
                this.questaoRepository.delete(questao);
            } else {
                throw new RuntimeException("Id não encontrado");
            }
        }
}
