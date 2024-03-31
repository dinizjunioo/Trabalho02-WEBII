package dev.dinizrodrigues.firstminiproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.dinizrodrigues.firstminiproject.model.Aluno;
import dev.dinizrodrigues.firstminiproject.model.Curso;
import dev.dinizrodrigues.firstminiproject.repository.AlunoRepository;

@Component
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void salvarAluno(Aluno aluno) {
        // aluno.setId(this.alunos.size()+1);
        System.out.println(aluno.toString());
        try {
            alunoRepository.save(aluno);
            // this.alunos.add(aluno);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    @Override
    public void deletarAluno(Aluno aluno) {
        if (aluno != null)
            alunoRepository.delete(aluno);
    }

    @Override
    public Aluno getAlunoById(Integer id) {

        return alunoRepository.findById(id).map(aluno -> {
            return aluno;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Aluno> getListaAluno() {
        return alunoRepository.findAll();
    }

    @Override
    public List<Aluno> getListAlunoByCurso(Curso curso) {
        // List<Aluno> alunosByCurso = new ArrayList<Aluno>();
        // for (Aluno aluno : getListaAluno()) {
        // if (aluno.getCurso().equals(curso))
        // // if (aluno.getCurso().toLowerCase().equals(curso.toLowerCase()))
        // alunosByCurso.add(aluno);
        // }
        // return alunosByCurso;
        return alunoRepository.getListAlunoByCurso(curso);
    }

    @Override
    public List<Aluno> getListAlunoByLingProgFav(String LingProgFav) {
        // List<Aluno> alunosByLingProgFav = new ArrayList<>();
        // for (Aluno aluno : getListaAluno()) {
        // if (aluno.getLinguagem().equalsIgnoreCase(LingProgFav))
        // // aluno.getLinguagem().toLowerCase().equals(LingProgFav.toLowerCase())
        // alunosByLingProgFav.add(aluno);
        // }
        // return alunosByLingProgFav;

        return alunoRepository.getListAlunoByLingProgFav(LingProgFav);
    }

    @Override
    public List<Aluno> getListAlunoAtLeastOneSisOp(String linguagemFav) {

        // List<Aluno> alunosComSisOpComum = new ArrayList<>();

        // for (Aluno aluno : getListaAluno()) {
        // List<String> sistemasOperacionaisFavoritos = aluno.getSistemasOperacionais();

        // if (sistemasOperacionaisFavoritos != null && !Collections.disjoint(
        // sistemasOperacionaisFavoritos.stream()
        // .map(String::toLowerCase)
        // .collect(Collectors.toList()),
        // List.of(linguagemFav.toLowerCase()))) {
        // alunosComSisOpComum.add(aluno);
        // }
        // }

        // return alunosComSisOpComum;

        return alunoRepository.getListAlunoAtLeastOneSisOp(linguagemFav);
    }
}
