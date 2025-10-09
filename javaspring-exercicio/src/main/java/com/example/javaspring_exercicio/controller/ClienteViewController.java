package com.example.javaspring_exercicio.controller;

import com.example.javaspring_exercicio.model.ClienteModel;
import com.example.javaspring_exercicio.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteViewController {

    private final ClienteService clienteService;

    public ClienteViewController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Formulário para cadastrar cliente
    @GetMapping("/cliente/cadastrar")
    public String formCliente(Model model){
        model.addAttribute("cliente", new ClienteModel());
        return "cliente-form"; // seu arquivo HTML em src/main/resources/templates
    }

    // Recebe dados do formulário e salva
    @PostMapping("/cliente/salvar-form")
    public String salvarClienteForm(@ModelAttribute ClienteModel cliente){
        clienteService.salvarCliente(cliente);
        return "redirect:/cliente/listar-view"; // redireciona para a lista HTML
    }

    // Listar clientes na tela
    @GetMapping("/cliente/listar-view")
    public String listarClientes(Model model){
        model.addAttribute("clientes", clienteService.listarCliente());
        return "listar-clientes"; // criar listar-clientes.html
    }
}
