package br.com.alura.springdata.specification;

import br.com.alura.springdata.model.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioSpecification {
    public static Specification<Funcionario> nome (String nome){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Funcionario> cpf (String cpf){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Funcionario> salario (BigDecimal salario){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
    }

    public static Specification<Funcionario> dataContratacao (LocalDate dataContratacao){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("dataContratacao"), dataContratacao);
    }

}
