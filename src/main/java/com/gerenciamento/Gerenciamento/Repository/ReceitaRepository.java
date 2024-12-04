package com.gerenciamento.Gerenciamento.Repository;

import com.gerenciamento.Gerenciamento.Models.Receita;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByUsuarioId(Long usuarioId);

    List<Receita> findByUsuarioIdAndDataBetween(Long usuarioId, LocalDate start, LocalDate end);

    List<Receita> findByUsuarioIdOrderByValorDesc(Long usuarioId, Pageable pageable);

    List<Receita> findByUsuarioIdOrderByValorAsc(Long usuarioId, Pageable pageable);
}