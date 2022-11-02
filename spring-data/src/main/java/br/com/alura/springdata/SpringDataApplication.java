package br.com.alura.springdata;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import br.com.alura.springdata.service.CrudUnidadeService;
import br.com.alura.springdata.service.RelatoriosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeService unidadeService;
    private final RelatoriosService relatoriosService;
    private boolean controle = true;
    int opcao;

    public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService,
                                 CrudUnidadeService unidadeService, RelatoriosService relatoriosService){
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeService = unidadeService;
        this.relatoriosService = relatoriosService;
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
            System.out.println("RELATORIO - 4");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    cargoService.inicial(scanner);
                    break;
                case 2:
                    funcionarioService.inicial(scanner);
                    break;
                case 3:
                    unidadeService.inicial(scanner);
                    break;
                case 4:
                    relatoriosService.inicial(scanner);
                    break;
                default:
                    controle = false;
                    break;
            }

        }
    }
}
