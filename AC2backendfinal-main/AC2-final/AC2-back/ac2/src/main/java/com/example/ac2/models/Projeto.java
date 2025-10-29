package com.example.ac2.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //Indica que esta classe é uma entidade JPA mapeada para uma tabela no banco de dados
@Data //Gera os métodos getters, setters, toString
@NoArgsConstructor //Gera um construtor sem argumentos
@AllArgsConstructor //Gera um construtor com todos os argumentos
@Builder //Implementa o padrão de projeto Builder para facilitar a criação de objetos
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao; // Descrição do projeto

    @Column
    private LocalDate dataInicio; // Data de início do projeto

    @Column
    private LocalDate dataFim; // Data de término do projeto

    @ManyToMany
    @JoinTable(name = "funcionario_projeto",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    @ToString.Exclude
    private List<Funcionario> funcionarios; // Funcionários vinculados ao projeto

    @Override
    public String toString() {
        // Retorna uma representação simplificada do projeto
        return "Projeto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}