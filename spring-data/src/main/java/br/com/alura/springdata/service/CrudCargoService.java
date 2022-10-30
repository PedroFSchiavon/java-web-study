package br.com.alura.springdata.service;

import br.com.alura.springdata.model.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    }

    public void insert(Scanner scanner, Cargo cargo){
        System.out.print("Descricao do cargo: ");
        String descricao = scanner.next();
        System.out.println();

        Cargo cargoParaAtualizar = cargo;
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
    }

    public void atualizar(Scanner scanner){
        System.out.print("Id do cargo: ");
        Integer id = scanner.nextInt();
        System.out.println();

        Optional<Cargo> cargoOptional = cargoRepository.findById(id);

        if(cargoOptional.isPresent()){
            Cargo cargo = cargoOptional.get();
            insert(scanner, cargo);
        }else{
            System.out.println("Nenhum cargo localizado com esse ID.");
        }
    }
}
