package com.treinaweb.twclientes.controller;

import com.treinaweb.twclientes.model.ClienteModel;
import com.treinaweb.twclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

        List<ClienteModel> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");

        ClienteModel cliente = clienteRepository.getReferenceById(id);
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView exlcuir(@PathVariable Long id){

        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

        clienteRepository.deleteById(id);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastro(){
        ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

        modelAndView.addObject("cliente", new ClienteModel());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastro(ClienteModel cliente){
        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

        clienteRepository.save(cliente);

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/editar");

        ClienteModel cliente = clienteRepository.getReferenceById(id);

        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(ClienteModel cliente){
        ModelAndView modelAndView = new ModelAndView("redirect:/editar");

        clienteRepository.save(cliente);

        return modelAndView;
    }
}
