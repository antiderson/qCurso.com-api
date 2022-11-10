package br.com.uniamerica.qCurso.com.qCurso.comapi.service;


import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Estudante;
import br.com.uniamerica.qCurso.com.qCurso.comapi.entity.Resolucao;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.EstudanteRepository;
import br.com.uniamerica.qCurso.com.qCurso.comapi.repository.ResolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ResolucaoService {

    @Autowired
    private ResolucaoRepository resolucaoRepository;

    public Resolucao findById(Long id) {
        return this.resolucaoRepository.findById(id).orElse(new Resolucao());
    }

    public List<Resolucao> listAll() {
        return this.resolucaoRepository.findAll();
    }

    @Transactional
    public Resolucao save(Resolucao resolucao) {
        return this.resolucaoRepository.save(resolucao);
    }

    @Transactional
    public void atualizar(final Long id, final Resolucao resolucao) {
        if (id.equals(resolucao.getId()) && !this.resolucaoRepository.findById(id).isEmpty()) {
            this.resolucaoRepository.save(resolucao);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void excluir(final Long id, final Resolucao resolucao) {
        if (id.equals(resolucao.getId()) && !this.resolucaoRepository.findById(id).isEmpty()) {
            this.resolucaoRepository.delete(resolucao);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}
