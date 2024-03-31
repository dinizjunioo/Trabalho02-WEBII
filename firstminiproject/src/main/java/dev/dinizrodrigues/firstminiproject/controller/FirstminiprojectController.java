package dev.dinizrodrigues.firstminiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import dev.dinizrodrigues.firstminiproject.service.MockDataService;

@Controller
public class FirstminiprojectController {

    @Value("${spring.application.name}")
    private String nomeApp;

    @Autowired
    MockDataService mockDataService;

    @GetMapping("/")
    public String showMenu(Model model) {

        model.addAttribute("cursos", mockDataService.getCursos());
        model.addAttribute("sistemasOperacionais", mockDataService.getSistemasOperacionais());
        return "menu";
    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "ola-form";
    }
}
