package com.example.ac2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.dtos.FuncionarioDTO;
import com.example.ac2.services.FuncionarioService;


@RestController //RestController indica que esta classe é um controlador REST
@RequestMapping("/funcionarios") //Mapeia as requisições HTTP para o caminho /funcionarios
public class FuncionarioController {

    private final FuncionarioService service; //Injeção de dependência do serviço FuncionarioService

    //Construtor que recebe o serviço como parâmetro
    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    
    @PostMapping //Mapeia as requisições HTTP POST para este método
    public void criarFuncionario(@RequestBody FuncionarioDTO dto) {
        service.adicionar(dto);
    }

     
    @GetMapping("/{id}/projetos") //Mapeia as requisições HTTP GET para este método, com o ID do funcionário na URL
    public List<DadosProjetoDTO> listarProjetosPorFuncionario(@PathVariable Integer id) {
        return service.buscarProjetos(id);
    }
}
