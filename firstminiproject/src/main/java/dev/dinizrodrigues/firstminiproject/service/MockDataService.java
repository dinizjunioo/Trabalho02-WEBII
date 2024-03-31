package dev.dinizrodrigues.firstminiproject.service;

//import java.util.List;

import org.springframework.stereotype.Component;

//import dev.dinizrodrigues.firstminiproject.model.Aluno;

@Component
public class MockDataService {
    
    private final String[] cursos = {
        "BTI", "EngSoft", "EngComp", "CienComp"
    };

    private final String[] sistemasOperacionais = {
        "OSX", "Windows", "Linux"
    };
    
    // private final Aluno[] alunosIniciais = {
    //     new Aluno("Arthur", "Moreira", cursos[0], "Java", null, List.of(sistemasOperacionais[0], sistemasOperacionais[1])),
    //     new Aluno("Gabriel", "Silva", cursos[1], "Python", null, List.of(sistemasOperacionais[0], sistemasOperacionais[1])),
    //     new Aluno("Laura", "Oliveira", cursos[2], "Java", null, List.of(sistemasOperacionais[2], sistemasOperacionais[1])),
    //     new Aluno("Luiza", "Santos", cursos[3], "JavaScript", null, List.of(sistemasOperacionais[1])),
    //     new Aluno("Pedro", "Souza", cursos[0], "Python", null, List.of(sistemasOperacionais[2])),
    //     new Aluno("Julia", "Costa", cursos[1], "Java", null, List.of(sistemasOperacionais[0])),
    //     new Aluno("Mariana", "Ferreira", cursos[2], "C", null, List.of(sistemasOperacionais[1], sistemasOperacionais[2])),
    //     new Aluno("Lucas", "Carvalho", cursos[3], "Python", null, List.of(sistemasOperacionais[1], sistemasOperacionais[2])),
    //     new Aluno("Ana", "Almeida", cursos[0], "JavaScript", null, List.of(sistemasOperacionais[0], sistemasOperacionais[2])),
    //     new Aluno("Felipe", "Martins", cursos[1], "C", null, List.of(sistemasOperacionais[0], sistemasOperacionais[2]))
    // };

    // public  Aluno[] getAlunos(){
    //     return alunosIniciais;
    // }

    public String[] getCursos() {
        return cursos;
    }
    public String[] getSistemasOperacionais() {
        return sistemasOperacionais;
    }


}
