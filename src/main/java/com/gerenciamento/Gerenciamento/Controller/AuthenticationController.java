package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Dto.AutheticationDTO;
import com.gerenciamento.Gerenciamento.Dto.RegistroDTO;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutheticationDTO request) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getSenha());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity registrar(@RequestBody @Valid RegistroDTO request) {
        if(this.repository.findByLogin(request.getLogin()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder().encode(request.getSenha());
        Usuario usuario = new Usuario(request.getLogin(), senhaCriptografada, request.getRole());

        this.repository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
