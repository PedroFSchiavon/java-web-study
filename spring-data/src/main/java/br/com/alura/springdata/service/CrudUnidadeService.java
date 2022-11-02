package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Cargo;
import br.com.alura.springdata.model.Funcionario;
import br.com.alura.springdata.model.Unidade;
import br.com.alura.springdata.repository.FuncionarioRepository;
import br.com.alura.springdata.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudUnidadeService {
    private final UnidadeRepository unidadeRepository;
    private final FuncionarioRepository funcionarioRepository;
    private boolean controle = true;

    public CrudUnidadeService(UnidadeRepository unidadeRepository,
                              FuncionarioRepository funcionarioRepository) {
        this.unidadeRepository = unidadeRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (controle) {
            System.out.println("MENU - UNIDADE");
            System.out.println("SAIR - 0");
            System.out.println("INSERIR - 1");
            System.out.println("ATUALIZAR - 2");
            System.out.println("DELETAR - 3");
            System.out.println("EXIBIR CADASTRO - 4");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    insert(scanner);
                    break;
                case 2:
                    update(scanner);
                    break;
                case 3:
                    delete(scanner);
                    break;
                case 4:
                    select();
                    break;
                default:
                    controle = false;
                    break;
            }
        }
        controle = true;
    }

    private void select() {
        Iterable<Unidade> unidades = unidadeRepository.findAll();
        unidades.forEach(System.out::println);
    }

    private void delete(Scanner scanner) {
        System.out.print("Id da unidade: ");
        Integer id = scanner.nextInt();
        System.out.println();

        unidadeRepository.deleteById(id);

        System.out.println("Unidade deletada com sucesso.");
    }

    private void update(Scanner scanner) {
        System.out.print("Id da unidade: ");
        Integer id = scanner.nextInt();
        System.out.println();
        System.out.print("Descricao da unidade: ");
        String descricao = scanner.next();
        System.out.println();
        System.out.print("Endereco da unidade: ");
        String endereco = scanner.next();
        System.out.println();

        Unidade unidade = new Unidade(descricao, endereco);
        unidade.setId(id);

        unidadeRepository.save(unidade);

        System.out.println("Unidade atualizada com sucesso!");
    }

    private void insert(Scanner scanner) {
        System.out.print("Descricao da unidade: ");
        String descricao = scanner.next();
        System.out.println();
        System.out.print("Endereco da unidade: ");
        String endereco = scanner.next();
        System.out.println();
        System.out.print("Id do funcionario: ");
        Integer id = scanner.nextInt();
        System.out.println();

        Unidade unidade = new Unidade(descricao, endereco);

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        Funcionario funcionario = funcionarioOptional.get();
        unidade.setFuncionarios(funcionario);
        unidadeRepository.save(unidade);

        System.out.println("Unidade salva com sucesso");
    }
}
