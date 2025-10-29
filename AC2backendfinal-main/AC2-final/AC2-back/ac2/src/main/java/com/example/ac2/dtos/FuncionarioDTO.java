package com.example.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera os métodos getters, setters, toString
@Builder //Implementa o padrão de projeto Builder para facilitar a criação de objetos
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor //Gera um construtor com todos os argumentos
public class FuncionarioDTO {
    private Integer id;
    private String nome;
}
