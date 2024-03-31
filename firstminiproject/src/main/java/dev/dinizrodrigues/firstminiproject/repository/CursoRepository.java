package dev.dinizrodrigues.firstminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.dinizrodrigues.firstminiproject.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
