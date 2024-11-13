package com.gerenciamento.Gerenciamento.Repository;

import com.gerenciamento.Gerenciamento.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
