package com.gerenciamento.Gerenciamento.Service;

import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.UsuarioOutput;
import com.gerenciamento.Gerenciamento.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioOutput cadastrarUsuario(Usuario input) {
        return new UsuarioOutput(repository.save(input));
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

}
