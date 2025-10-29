package com.example.ac2.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.services.ProjetoService;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService service; // Injeção de dependência do serviço ProjetoService

    public ProjetoController(ProjetoService service) { // Construtor que recebe o serviço como parâmetro
        this.service = service;
    }

    @PostMapping // Mapeia requisições HTTP POST para criar um novo projeto
    public void criarProjeto(@RequestBody ProjetoDTO dto) {
        service.adicionar(dto);
    }

    @GetMapping("/{id}") // Mapeia GET /projeto/{id} para buscar um projeto específico
    public DadosProjetoDTO obterProjetoPorId(@PathVariable Integer id) {
        return service.buscarProjetoPorId(id);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}") // POST para associar funcionário a projeto
    public void associarFuncionario(@PathVariable Integer idProjeto,
                                    @PathVariable Integer idFuncionario) {
        service.vincularFuncionario(idProjeto, idFuncionario);
    }

    // ✅ Novo endpoint para integração com o front-end
    @GetMapping // GET /projeto
    public List<DadosProjetoDTO> listarProjetos() {
        return service.listarTodos();
    }
}
