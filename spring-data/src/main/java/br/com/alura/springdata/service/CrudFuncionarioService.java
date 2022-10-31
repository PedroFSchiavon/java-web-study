package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Cargo;
import br.com.alura.springdata.model.Funcionario;
import br.com.alura.springdata.repository.CargoRepository;
import br.com.alura.springdata.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    private CargoRepository cargoRepository;
    private boolean controle = true;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository){
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner){
        while (controle){
            System.out.println("MENU - Funcionarios");
            System.out.println("SAIR - 0");
            System.out.println("INSERIR - 1");
            System.out.println("ATUALIZAR - 2");
            System.out.println("DELETAR - 3");
            System.out.println("EXIBIR CADASTRO - 4");
            Integer opcao = scanner.nextInt();

            switch (opcao){
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
    }

    private void select() {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();

        funcionarios.forEach(System.out::println);
    }

    private void delete(Scanner scanner) {
        System.out.print("Id: ");
        Integer id = scanner.nextInt();
        System.out.println();
        
        funcionarioRepository.deleteById(id);

        System.out.println("FUncionario deletado");
    }

    private void update(Scanner scanner) {
        System.out.print("Id: ");
        Integer id = scanner.nextInt();
        System.out.println();
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.println();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.println();
        System.out.print("Salario: ");
        BigDecimal salario = new BigDecimal(scanner.next());
        System.out.println();
        System.out.print("Id do cargo: ");
        Optional<Cargo> cargoOptional = cargoRepository.findById(scanner.nextInt());
        Cargo cargo = cargoOptional.get();

        Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo);
        funcionario.setId(id);
        
        funcionarioRepository.save(funcionario);

        System.out.println("Funcionario atualizado");
        
    }

    private void insert(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.println();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.println();
        System.out.print("Salario: ");
        BigDecimal salario = new BigDecimal(scanner.next());
        System.out.println();
        System.out.print("Id do cargo: ");
        Optional<Cargo> cargoOptional = cargoRepository.findById(scanner.nextInt());
        Cargo cargo = cargoOptional.get();

        Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo);
        
        funcionarioRepository.save(funcionario);

        System.out.println("Funcionario salvo com sucesso.");
    }
}
