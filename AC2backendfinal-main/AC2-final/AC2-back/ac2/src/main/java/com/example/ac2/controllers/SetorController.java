package com.example.ac2.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.dtos.DadosSetorDTO;
import com.example.ac2.services.SetorService;


  // Controlador responsável por gerenciar operações relacionadas a setores.

@RestController // RestController indica que esta classe é um controlador REST
@RequestMapping("/setor")
public class SetorController {

    private final SetorService service; //Injeção de dependência do serviço SetorService

    public SetorController(SetorService service) {
        this.service = service;
    }

  
    @PostMapping //Mapeia as requisições HTTP POST para este método
    public void criarSetor(@RequestBody SetorDTO dto) {
        service.adicionar(dto);
    }

    @GetMapping("/{id}") // Mapeia as requisições HTTP GET para este método, com o ID do setor na URL
    public DadosSetorDTO obterSetorPorId(@PathVariable Integer id) {
        return service.buscarSetorPorId(id);
    }
}
