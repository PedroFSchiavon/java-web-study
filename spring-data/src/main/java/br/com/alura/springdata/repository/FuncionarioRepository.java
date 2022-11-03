package br.com.alura.springdata.repository;

import br.com.alura.springdata.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario " +
            "and f.dataContratacao = :dataContratacao")
    List<Funcionario> findNomeContratacaoSalarioMaior(String nome, BigDecimal salario, LocalDate dataContratacao);
}
