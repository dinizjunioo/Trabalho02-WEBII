package dev.dinizrodrigues.firstminiproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.dinizrodrigues.firstminiproject.model.Curso;

@Service
public interface CursoService {
    
    public void salvarCurso(Curso aluno);
    public void deletarCurso(Curso aluno);
    public Curso getCursoById(Integer id);
    public List<Curso> getListaCursos();
    
}
