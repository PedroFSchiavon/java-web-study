package br.com.alura.springdata.repository;

import br.com.alura.springdata.model.Funcionario;
import br.com.alura.springdata.model.FuncionarioProjecao;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
        JpaSpecificationExecutor<Funcionario> {
    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario " +
            "and f.dataContratacao = :dataContratacao")
    List<Funcionario> findNomeContratacaoSalarioMaior(String nome, BigDecimal salario, LocalDate dataContratacao);

    @Query(value = "SELECT f.id, f.nome, f.salario FROM funcionario f", nativeQuery = true)
    List<FuncionarioProjecao> findIdNomeSalario();
}
