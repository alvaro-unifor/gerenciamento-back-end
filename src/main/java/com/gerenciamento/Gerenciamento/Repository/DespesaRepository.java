package com.gerenciamento.Gerenciamento.Repository;

import com.gerenciamento.Gerenciamento.Models.Despesa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findByUsuarioId(Long usuarioId);

    List<Despesa> findByUsuarioIdAndDataBetween(Long usuarioId, LocalDate dataInicio, LocalDate dataFim);

    List<Despesa> findByUsuarioIdOrderByValorDesc(Long usuarioId, Pageable pageable);

    List<Despesa> findByUsuarioIdOrderByValorAsc(Long usuarioId, Pageable pageable);
}