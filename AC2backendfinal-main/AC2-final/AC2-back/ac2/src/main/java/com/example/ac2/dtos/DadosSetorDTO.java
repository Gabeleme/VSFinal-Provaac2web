package com.example.ac2.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera os métodos getters, setters, toString
@Builder //permite a construção de objetos de forma flexível
@NoArgsConstructor //Gera um construtor sem argumentos
@AllArgsConstructor //Gera um construtor com todos os argumentos
public class DadosSetorDTO {
    private Integer id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;
}
