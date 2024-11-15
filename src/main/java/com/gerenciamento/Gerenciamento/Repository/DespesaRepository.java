package com.gerenciamento.Gerenciamento.Repository;

import com.gerenciamento.Gerenciamento.Models.Despesa;
import com.gerenciamento.Gerenciamento.Models.Receita;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findByUsuarioId(Long usuarioId);

    List<Despesa> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

    List<Despesa> findByOrderByValorDesc(Pageable pageable);

    List<Despesa> findByOrderByValorAsc(Pageable pageable);
}
