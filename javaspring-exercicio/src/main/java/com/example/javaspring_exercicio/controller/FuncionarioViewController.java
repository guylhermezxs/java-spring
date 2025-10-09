package com.example.javaspring_exercicio.controller;



import com.example.javaspring_exercicio.model.FuncionarioModel;
import com.example.javaspring_exercicio.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioViewController {

    private final FuncionarioService funcionarioService;

    public FuncionarioViewController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionario/cadastrar")
    public String formFuncionario(Model model){
        model.addAttribute("funcionario", new FuncionarioModel());
        return "funcionario-form"; // seu arquivo HTML em src/main/resources/templates
    }

    @PostMapping("/funcionario/salvar-form")
    public String salvarFuncionarioForm(@ModelAttribute FuncionarioModel funcionario){
        funcionarioService.salvarFuncionario(funcionario);
        return "redirect:/funcionario/listar-view"; // redireciona para a lista HTML
    }

    @GetMapping("/funcionario/listar-view")
    public String listarFuncionario(Model model){
        model.addAttribute("funcionario", funcionarioService.listarFuncionario());
        return "listar-funcionario"; // criar listar-clientes.html
    }

}
