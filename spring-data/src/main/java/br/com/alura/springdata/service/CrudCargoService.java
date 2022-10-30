package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class CrudCargoService {
    private CargoRepository cargoRepository;
    public CrudCargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public void insert(Scanner scanner){
        System.out.print("Descricao do cargo: ");
        String descricao = scanner.next();
        System.out.println();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
        System.out.println("Salvo com sucesso!");
    }

    public void update(Scanner scanner){
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

    public void delete(Scanner scanner) {
        System.out.print("Id do cargo: ");
        Integer id = scanner.nextInt();
        System.out.println();

        cargoRepository.deleteById(id);
        System.out.println("Deletado com sucesso!");

    }

    public void select(Scanner scanner) {
        List<Cargo> cargos = (List<Cargo>) cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }
}
