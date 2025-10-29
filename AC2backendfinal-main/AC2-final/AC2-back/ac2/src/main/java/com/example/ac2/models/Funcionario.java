package com.example.ac2.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "funcionarios") // Define o relacionamento muitos-para-muitos com a entidade Projeto
    @ToString.Exclude // Exclui a lista de projetos do método toString para evitar recursão infinita
    private List<Projeto> projetos; // Lista de projetos vinculados ao funcionário

    @ManyToOne // Define o relacionamento muitos-para-um com a entidade Setor
    @JoinColumn(name = "setor_id") // Define a coluna de junção para o setor
    @ToString.Exclude // Exclui o setor do método toString para evitar recursão infinita
    private Setor setorVinculado; // Setor ao qual o funcionário pertence

    @Override //serve para sobrescrever o método toString padrão da classe Object
    public String toString() {
        // Retorna uma representação simplificada do funcionário
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
