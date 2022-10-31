package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class CrudCargoService {
    private CargoRepository cargoRepository;
    private boolean controle = true;
    public CrudCargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner){
        while (controle){
            System.out.println("MENU - Cargo");
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
        }}

    private void insert(Scanner scanner){
        System.out.print("Descricao do cargo: ");
        String descricao = scanner.next();
        System.out.println();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
        System.out.println("Salvo com sucesso!");
    }

    private void update(Scanner scanner){
        System.out.print("Id do cargo: ");
        Integer id = scanner.nextInt();
        System.out.println();

        System.out.print("Descricao do cargo: ");
        String descricao = scanner.next();
        System.out.println();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargo.setId(id);

        cargoRepository.save(cargo);
        System.out.println("Atualizado com sucesso!");
    }

    private void delete(Scanner scanner) {
        System.out.print("Id do cargo: ");
        Integer id = scanner.nextInt();
        System.out.println();

        cargoRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");

    }

    private void select() {
        List<Cargo> cargos = (List<Cargo>) cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }
}
