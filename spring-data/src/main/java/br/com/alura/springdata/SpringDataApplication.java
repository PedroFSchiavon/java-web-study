package br.com.alura.springdata;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private boolean controle = true;

    public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService){
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
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
            System.out.println("CARGO - 1");
            System.out.println("FUNCIONARIO - 2");
            System.out.println("UNIDADE - 3");
            Integer opcao = scanner.nextInt();

//            switch (opcao){
//                case 1:
//                    cargoService.inicial(scanner);
//                    break;
//                case 2:
//                    funcionarioService.inicial(scanner);
//                    break;
//                case 3:
//
//                    break;
//                default:
//                    controle = false;
//                    break;
//            }

        }
    }
}
