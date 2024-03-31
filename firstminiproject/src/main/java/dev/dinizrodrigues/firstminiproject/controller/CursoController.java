package dev.dinizrodrigues.firstminiproject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import dev.dinizrodrigues.firstminiproject.model.Curso;
import dev.dinizrodrigues.firstminiproject.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;
    
    @RequestMapping("/showFormCurso")
    public String showFormCurso(Model model){
        model.addAttribute("curso", new Curso());
        return "curso/formCurso";
    }

    @RequestMapping("/addCurso")
    public String showFormCurso(@ModelAttribute("curso") Curso curso,  Model model){
        cursoService.salvarCurso(curso);
        model.addAttribute("curso", curso);
        return "curso/paginaCurso";
    }

    @RequestMapping("/getListaCursos")
    public String showListaCurso(Model model){
        List<Curso> cursos = cursoService.getListaCursos();
        model.addAttribute("cursos",cursos);
        return "curso/listaCursos";

    }
}