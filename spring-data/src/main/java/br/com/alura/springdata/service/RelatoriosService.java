package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private boolean controle = true;
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        while (controle){
            System.out.println("MENU - RELATORIO");
            System.out.println("SAIR - 0");
            System.out.println("PESQUISA POR NOME - 1");
            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    pesquisaPorNome(scanner);
                    break;
                default:
                    controle = false;
                    break;
            }
        }}

    private void pesquisaPorNome(Scanner scanner){
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.println();

        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
        funcionarios.forEach(System.out::println);

    }
}
