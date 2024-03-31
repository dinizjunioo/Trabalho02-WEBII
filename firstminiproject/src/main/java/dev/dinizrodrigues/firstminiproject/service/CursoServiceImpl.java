package dev.dinizrodrigues.firstminiproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.dinizrodrigues.firstminiproject.model.Curso;
import dev.dinizrodrigues.firstminiproject.repository.CursoRepository;

@Component
public class CursoServiceImpl implements CursoService {

    // private List<Curso> cursos = new ArrayList<Curso>();

    CursoRepository cursoRepository;

    @Override
    public void salvarCurso(Curso curso) {
        // curso.setCodigo(this.cursos.size()+1);

        System.out.println(curso.toString());

        try {
            if (curso != null)
                cursoRepository.save(curso);
            // this.cursos.add(curso);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    @Override
    public void deletarCurso(Curso curso) {
        if (curso != null)
            cursoRepository.delete(curso);
        // this.cursos.remove(curso);
    }

    @Override
    public Curso getCursoById(Integer id) {

        return cursoRepository.findById(id).map(curso -> {
            return curso;
        }).orElseThrow(() -> null);
        // for (Curso curso : cursos) {
        // if (curso.getCodigo().equals(id)) {
        // return curso;
        // }
        // }
        // return null;
    }

    @Override
    public List<Curso> getListaCursos() {
        return cursoRepository.findAll();
        // return this.cursos;
    }

}
