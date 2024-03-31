package dev.dinizrodrigues.firstminiproject.controller;
//
import dev.dinizrodrigues.firstminiproject.model.Aluno;
import dev.dinizrodrigues.firstminiproject.model.Curso;
//
import dev.dinizrodrigues.firstminiproject.service.AlunoService;
import dev.dinizrodrigues.firstminiproject.service.CursoService;
import dev.dinizrodrigues.firstminiproject.service.MockDataService;
//
import java.util.List;
//
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @Autowired
    MockDataService mockDataService;

    @Autowired
    CursoService cursoService;

    @RequestMapping("/showForm")
    public String showFormAluno(Model model){
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", cursoService.getListaCursos());
        model.addAttribute("sistemasOperacionais", mockDataService.getSistemasOperacionais());
        return "aluno/formAluno";
    }


    @RequestMapping("/addAluno")
    public String addAluno(@ModelAttribute("aluno") Aluno aluno, @RequestParam("cursoSelecionado") Integer codigoCurso, Model model) {
        Curso curso = cursoService.getCursoById(codigoCurso); 
        aluno.setCurso(curso);
        alunoService.salvarAluno(aluno);
        model.addAttribute("aluno", aluno);
        return "aluno/paginaAluno";
    }

    @RequestMapping("/removeAluno/{id}")
    public String removeAluno(@PathVariable("id") Integer id, Model model) {
        alunoService.deletarAluno(alunoService.getAlunoById(id));
        List<Aluno> alunos = alunoService.getListaAluno();
        model.addAttribute("alunos",alunos);
        return "redirect:/aluno/getListaAlunos";
    }

    @RequestMapping("/getDetalhesAluno/{id}")
    public String detalhesAluno(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = alunoService.getAlunoById(id);
        System.out.println("teste -> " + aluno.toString());
        model.addAttribute("aluno",aluno);
        return "aluno/detalhesAluno";
    }


    @RequestMapping("/getListaAlunos")
    public String listaAluno(Model model){
        List<Aluno> alunos = alunoService.getListaAluno();
        List<Curso> cursos = cursoService.getListaCursos();
        model.addAttribute("cursos",cursos);
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";
    }

    @RequestMapping("/getListAlunoByCurso")
    public String showListaAlunoByCurso(@RequestParam("codigoCurso") Integer codigoCurso, Model model){
        Curso cursoSelecionado = cursoService.getCursoById(codigoCurso);
        List<Aluno> alunosPorCurso = alunoService.getListAlunoByCurso(cursoSelecionado);
        model.addAttribute("alunosPorCurso", alunosPorCurso);
        return "aluno/listaAlunosByCurso"; 
    }

    @RequestMapping("/getListAlunoByLinguagem")
    public String showListaAlunoByLinguagem(@RequestParam("linguagem") String lingFav, Model model){
        List<Aluno> alunosPorLingFav = alunoService.getListAlunoByLingProgFav(lingFav);
        model.addAttribute("alunosPorLing", alunosPorLingFav);
        return "aluno/listaAlunosByLinguagem"; 
    }

    @RequestMapping("/getListAlunoBySOFav")
    public String showListaAlunoBySOFav(@RequestParam("sistema") String sysFav, Model model){
        List<Aluno> alunosPorSOFav = alunoService.getListAlunoAtLeastOneSisOp(sysFav);
        model.addAttribute("alunosPorSO", alunosPorSOFav);
        model.addAttribute("SOFav", sysFav);
        return "aluno/listaAlunosBySOFav"; 
    }


    // Mock de alunos apenas para debug
    // ============>  nao funciona mais pois Agora curso é do tipo Curso e nao do tipo String <===================


    // @RequestMapping(value = "/Mock", method = RequestMethod.GET)
    // public String addAlunosMock(Model model) {
    //     Aluno[] alunosMockados = mockDataService.getAlunos();
    //     for (Aluno aluno : alunosMockados) {
    //         alunoService.salvarAluno(aluno);
    //     }
    //     // for (Aluno aluno : alunoService.getListaAluno()) {
    //     //     System.out.println("alunos " + aluno.getPrimeiroNome() + aluno.getSistemasOperacionas().get(0));
    //     // }
    //     return "redirect:/aluno/getListaAlunos";
    // }
}
