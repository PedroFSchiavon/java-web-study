package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private boolean controle = true;
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (controle) {
            System.out.println("MENU - RELATORIO");
            System.out.println("SAIR - 0");
            System.out.println("PESQUISA POR NOME - 1");
            System.out.println("PESQUISA NOME, CONTRATACAO, MAIOR SALARIO");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    pesquisaPorNome(scanner);
                    break;
                case 2:
                    pesquisaNomeContratacaoSalarioMaior(scanner);
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

    private void pesquisaNomeContratacaoSalarioMaior(Scanner scanner){
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.println();
        System.out.print("Salario: ");
        BigDecimal salario = new BigDecimal(scanner.next());
        System.out.println();
        System.out.print("Contratacao: ");
        LocalDate contratacao = LocalDate.parse(scanner.next());
        System.out.println();

        List<Funcionario> funcionarios = funcionarioRepository
                .findNomeContratacaoSalarioMaior(nome, salario, contratacao);
        funcionarios.forEach(System.out::println);
    }
}
