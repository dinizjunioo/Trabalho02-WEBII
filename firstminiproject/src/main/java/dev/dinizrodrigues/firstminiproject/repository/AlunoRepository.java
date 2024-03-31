package dev.dinizrodrigues.firstminiproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.dinizrodrigues.firstminiproject.model.Aluno;
import dev.dinizrodrigues.firstminiproject.model.Curso;
import jakarta.persistence.EntityManager;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    // @Autowired
    // private EntityManager entityManager;

    // @transactional
    @Query("SELECT a FROM Aluno a WHERE a.curso = :curso")
    List<Aluno> getListAlunoByCurso(@Param("curso") Curso curso);

    @Query("SELECT a FROM Aluno a WHERE LOWER(a.linguagem) = LOWER(:lingProgFav)")
    List<Aluno> getListAlunoByLingProgFav(@Param("lingProgFav") String lingProgFav);

    @Query("SELECT DISTINCT a FROM Aluno a JOIN a.sistemasOperacionais s WHERE LOWER(s) = LOWER(:sistema)")
    List<Aluno> getListAlunoAtLeastOneSisOp(@Param("sistema") String sistema);
}
