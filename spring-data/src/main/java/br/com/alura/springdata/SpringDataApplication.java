package br.com.alura.springdata;

import br.com.alura.springdata.model.Cargo;
import br.com.alura.springdata.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.springdata.repository.CargoRepository;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
    private final CrudCargoService cargoService;
    private boolean controle = true;

    public SpringDataApplication(CrudCargoService cargoService){
        this.cargoService = cargoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (controle){
            System.out.println("MENU");
            System.out.println("SAIR - 0");
            System.out.println("INSERIR - 1");
            System.out.println("ATUALIZAR - 2");
            int opcao = scanner.nextInt();

            switch (opcao){
                case 0:
                    controle = false;
                    break;
                case 1:
                    cargoService.insert(scanner);
                    break;
                case 2:
                    cargoService.atualizar(scanner);
            }

        }
    }
}
