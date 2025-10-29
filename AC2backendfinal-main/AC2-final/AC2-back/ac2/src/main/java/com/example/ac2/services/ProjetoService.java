package com.example.ac2.services;

import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.dtos.ProjetoDTO;
import java.util.List;

public interface ProjetoService {

    void adicionar(ProjetoDTO projetoDTO);

    DadosProjetoDTO buscarProjetoPorId(Integer id);

    void vincularFuncionario(Integer idProjeto, Integer idFuncionario);

    List<DadosProjetoDTO> listarTodos();
}
