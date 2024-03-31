package dev.dinizrodrigues.firstminiproject.service;
import dev.dinizrodrigues.firstminiproject.model.Aluno;
import dev.dinizrodrigues.firstminiproject.model.Curso;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface AlunoService {

    public void salvarAluno(Aluno aluno);
    public void deletarAluno(Aluno aluno);
    public Aluno getAlunoById(Integer id);
    public List<Aluno> getListaAluno();
    public List<Aluno> getListAlunoByCurso(Curso curso);
    public List<Aluno> getListAlunoByLingProgFav(String linguagem);
    public List<Aluno> getListAlunoAtLeastOneSisOp(String linguagemFav);

}