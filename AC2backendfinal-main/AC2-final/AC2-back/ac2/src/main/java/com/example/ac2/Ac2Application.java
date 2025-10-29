package com.example.ac2;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.ProjetoRepository;
import com.example.ac2.repositories.SetorRepository;

@SpringBootApplication
public class Ac2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}

	@Bean
	public CommandLineRunner init(@Autowired ProjetoRepository projetoRepository,
			@Autowired FuncionarioRepository funcionarioRepository, @Autowired SetorRepository setorRepository) {
		return args -> {
			// criar setores
			Setor s1 = setorRepository.save(Setor.builder().nome("Financeiro").build());
			Setor s2 = setorRepository.save(Setor.builder().nome("Design e Criação").build());
			Setor s3 = setorRepository.save(Setor.builder().nome("Operações").build());

			// criar funcionários e associar setor
			Funcionario f1 = Funcionario.builder().nome("Lucas Andrade").setorVinculado(s1).build();
			Funcionario f2 = Funcionario.builder().nome("Fernanda Oliveira").setorVinculado(s2).build();
			Funcionario f3 = Funcionario.builder().nome("Ricardo Gomes").setorVinculado(s3).build();
			Funcionario f4 = Funcionario.builder().nome("Patrícia Nunes").setorVinculado(s1).build();
			Funcionario f5 = Funcionario.builder().nome("Eduardo Lima").setorVinculado(s2).build();

			f1 = funcionarioRepository.save(f1);
			f2 = funcionarioRepository.save(f2);
			f3 = funcionarioRepository.save(f3);
			f4 = funcionarioRepository.save(f4);
			f5 = funcionarioRepository.save(f5);

			// criar projetos
			Projeto p1 = Projeto.builder()
					.descricao("Plataforma de Controle Financeiro")
					.dataInicio(LocalDate.now().minusDays(5))
					.dataFim(LocalDate.now().plusDays(40))
					.build();

			Projeto p2 = Projeto.builder()
					.descricao("Rebranding da Marca")
					.dataInicio(LocalDate.now().plusDays(3))
					.dataFim(LocalDate.now().plusDays(45))
					.build();

			Projeto p3 = Projeto.builder()
					.descricao("Automação de Processos Internos")
					.dataInicio(LocalDate.now().plusDays(15))
					.dataFim(LocalDate.now().plusDays(60))
					.build();

			// associar funcionários aos projetos
			p1.setFuncionarios(new ArrayList<>());
			p1.getFuncionarios().add(f1);
			p1.getFuncionarios().add(f4);

			p2.setFuncionarios(new ArrayList<>());
			p2.getFuncionarios().add(f2);
			p2.getFuncionarios().add(f5);

			p3.setFuncionarios(new ArrayList<>());
			p3.getFuncionarios().add(f3);
			p3.getFuncionarios().add(f4);
			p3.getFuncionarios().add(f5);

			p1 = projetoRepository.save(p1);
			p2 = projetoRepository.save(p2);
			p3 = projetoRepository.save(p3);

			// atualizar lista de projetos nos funcionários
			f1.setProjetos(new ArrayList<>());
			f1.getProjetos().add(p1);
			funcionarioRepository.save(f1);

			f2.setProjetos(new ArrayList<>());
			f2.getProjetos().add(p2);
			funcionarioRepository.save(f2);

			f3.setProjetos(new ArrayList<>());
			f3.getProjetos().add(p3);
			funcionarioRepository.save(f3);

			f4.setProjetos(new ArrayList<>());
			f4.getProjetos().add(p1);
			f4.getProjetos().add(p3);
			funcionarioRepository.save(f4);

			f5.setProjetos(new ArrayList<>());
			f5.getProjetos().add(p2);
			f5.getProjetos().add(p3);
			funcionarioRepository.save(f5);

			// exibir dados inseridos
			System.out.println("Setores:");
			setorRepository.findAll().forEach(System.out::println);

			System.out.println("Funcionários:");
			funcionarioRepository.findAll().forEach(System.out::println);

			System.out.println("Projetos com início nos próximos 20 dias:");
			projetoRepository.findByDataInicioBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(20))
					.forEach(System.out::println);
		};
	}

}
