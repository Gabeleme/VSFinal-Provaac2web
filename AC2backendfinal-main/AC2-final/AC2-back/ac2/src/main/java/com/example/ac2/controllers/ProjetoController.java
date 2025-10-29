package com.example.ac2.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.services.ProjetoService;


@RestController //RestController indica que esta classe é um controlador REST
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService service; //Injeção de dependência do serviço ProjetoService

    public ProjetoController(ProjetoService service) { //Construtor que recebe o serviço como parâmetro
        this.service = service;
    }


    @PostMapping //Mapeia as requisições HTTP POST para este método, Post é usado para criar
    public void criarProjeto(@RequestBody ProjetoDTO dto) {
        service.adicionar(dto);
    }


    @GetMapping("/{id}") //Mapeia as requisições HTTP GET para este método, com o ID do projeto na URL
    public DadosProjetoDTO obterProjetoPorId(@PathVariable Integer id) {
        return service.buscarProjetoPorId(id);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}") //Mapeia as requisições HTTP POST para este método, usado para associar funcionário a projeto
    public void associarFuncionario(@PathVariable Integer idProjeto,
                                    @PathVariable Integer idFuncionario) {
        service.vincularFuncionario(idProjeto, idFuncionario);
    }
}
