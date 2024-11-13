package com.gerenciamento.Gerenciamento.Service;

import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.CategoriaOutput;
import com.gerenciamento.Gerenciamento.Outputs.UsuarioOutput;
import com.gerenciamento.Gerenciamento.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<UsuarioOutput> listarUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioOutput> lista = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            lista.add(new UsuarioOutput(usuario));
        }
        return lista;
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

}
