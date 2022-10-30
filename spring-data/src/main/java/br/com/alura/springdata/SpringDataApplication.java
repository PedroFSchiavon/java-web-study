package br.com.alura.springdata;

import br.com.alura.springdata.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
            System.out.println("DELETAR - 3");
            System.out.println("EXIBIR CADASTRO - 4");
            Integer opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    cargoService.insert(scanner);
                    break;
                case 2:
                    cargoService.update(scanner);
                    break;
                case 3:
                    cargoService.delete(scanner);
                    break;
                case 4:
                    cargoService.select(scanner);
                    break;
                default:
                    controle = false;
                    break;
            }

        }
    }
}
