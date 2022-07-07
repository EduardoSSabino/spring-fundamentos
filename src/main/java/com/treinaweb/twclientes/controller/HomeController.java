package com.treinaweb.twclientes.controller;

import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home"; // retornando o nome da view que irá ser acessada
    }

    @GetMapping("/mensagem")
    public ModelAndView mensagem(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("mensagem"); //  passando a view a ser acessada
        modelAndView.addObject("mensagem", "Mensagem vinda do servidor");// passando os parametros que a minha view tem

        return modelAndView;
    }

    @GetMapping("/saudacao/{nome}")
    public ModelAndView saudacao(@RequestParam(required = false, defaultValue = "TreinaWeb") String nome){
        /*
         EX: baseURL/saudacao?nome=Fulano;
         o parametro ira vir do próprio endpoint, porem não é obrigatorio (required = false)
         e caso não tenha passado nenhum valor na rota, o valor será 'TreinaWeb'
         */

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("saudacao");
        modelAndView.addObject("nome", nome);
        return modelAndView;
    }



}
