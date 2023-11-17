package com.br.guerreiras.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.br.guerreiras.model.Cursos;
import com.br.guerreiras.repository.CursosRepository;

@Controller
@RequestMapping("/novocurso")
public class CursosController {

    @Autowired
    private CursosRepository cursosRepository;

    @GetMapping("/novocurso")
    public ModelAndView novocurso() {
        ModelAndView page = new ModelAndView("novocurso/novocurso");
        page.addObject("cursos", new Cursos());
        return page;
    }

    @GetMapping
    public ModelAndView listar() {
        ModelAndView page = new ModelAndView("novocurso/listarcurso");
        List<Cursos> cursos = cursosRepository.findAll();
        page.addObject("cursos", cursos);
        return page;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarCurso(@ModelAttribute Cursos cursos) {
        ModelAndView modelAndView = new ModelAndView("redirect:/novocurso");

        cursosRepository.save(cursos);

        return modelAndView;
    }
}
