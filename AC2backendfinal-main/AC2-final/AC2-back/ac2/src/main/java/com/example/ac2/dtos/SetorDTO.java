package com.example.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera os métodos getters, setters, toString
@NoArgsConstructor //Gera um construtor sem argumentos
@AllArgsConstructor //Gera um construtor com todos os argumentos
@Builder // Implementa o padrão de projeto Builder para facilitar a criação de objetos
public class SetorDTO {
    private Integer id;
    private String nome;
}
