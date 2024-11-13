package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Dto.UsuarioDTO;
import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.CategoriaOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Outputs.UsuarioOutput;
import com.gerenciamento.Gerenciamento.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<UsuarioOutput> cadastrarUsuario(@RequestBody UsuarioDTO request) {
        Usuario usuario = new Usuario(request);
        UsuarioOutput response = service.cadastrarUsuario(usuario);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<List<UsuarioOutput>> listarUsuarios() {
        List<UsuarioOutput> response = service.listarUsuarios();
        return ResponseEntity.ok(response);
    }
}
