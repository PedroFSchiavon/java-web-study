package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;
import br.com.alura.springdata.specification.FuncionarioSpecification;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private boolean controle = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (controle) {
            System.out.println("MENU - RELATORIO");
            System.out.println("SAIR - 0");
            System.out.println("PESQUISA POR NOME - 1");
            System.out.println("PESQUISA NOME, CONTRATACAO, MAIOR SALARIO - 2");
            System.out.println("PESQUISA DINAMICA - 3");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    pesquisaPorNome(scanner);
                    break;
                case 2:
                    pesquisaNomeContratacaoSalarioMaior(scanner);
                    break;
                case 3:
                    pesquisaSpecification(scanner);
                    break;
                default:
                    controle = false;
                    break;
            }
        }
        controle = true;
    }

    private void pesquisaPorNome(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.println();

        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
        funcionarios.forEach(System.out::println);

    }

    private void pesquisaNomeContratacaoSalarioMaior(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.println();
        System.out.print("Salario: ");
        BigDecimal salario = new BigDecimal(scanner.next());
        System.out.println();
        System.out.print("Contratacao: ");
        LocalDate contratacao = LocalDate.parse(scanner.next(), formatter);
        System.out.println();

        List<Funcionario> funcionarios = funcionarioRepository
                .findNomeContratacaoSalarioMaior(nome, salario, contratacao);
        funcionarios.forEach(System.out::println);
    }

    public void pesquisaSpecification(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.println();

        System.out.print("Cpf: ");
        String cpf = scanner.next();
        System.out.println();

        System.out.print("Salario: ");
        String salario = scanner.next();
        BigDecimal salarioReal;
        System.out.println();

        System.out.print("Contratacao: ");
        String data = scanner.next();
        LocalDate dataContratacao;
        System.out.println();

        if (nome.equalsIgnoreCase("NULL")) {
            nome = null;
        }

        if (cpf.equalsIgnoreCase("NULL")) {
            cpf = null;
        }

        if (salario.equalsIgnoreCase("0")) {
            salarioReal = null;
        } else {
            salarioReal = new BigDecimal(salario);
        }

        if (data.equalsIgnoreCase("NULL")) {
            dataContratacao = null;
        } else {
            dataContratacao = LocalDate.parse(data, formatter);
        }

        System.out.println("Nome = " + nome);
        System.out.println("Cpf = " + cpf);
        System.out.println("Salario = " + salarioReal);
        System.out.println("data = " + dataContratacao);


        List<Funcionario> funcionarios = funcionarioRepository.
                findAll(Specification.where(FuncionarioSpecification.nome(nome))
                        .or(FuncionarioSpecification.cpf(cpf))
                        .or(FuncionarioSpecification.salario(salarioReal))
                        .or(FuncionarioSpecification.dataContratacao(dataContratacao)));

        funcionarios.forEach(System.out::println);
    }
}
