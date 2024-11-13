package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Outputs.UsuarioOutput;
import com.gerenciamento.Gerenciamento.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<UsuarioOutput> cadastrarUsuario(@RequestBody Usuario request) {
        UsuarioOutput response = service.cadastrarUsuario(request);
        return ResponseEntity.ok(response);
    }
}
