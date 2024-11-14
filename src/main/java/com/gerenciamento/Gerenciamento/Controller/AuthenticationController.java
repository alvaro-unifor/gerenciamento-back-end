package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Dto.AutheticationDTO;
import com.gerenciamento.Gerenciamento.Outputs.LoginOutput;
import com.gerenciamento.Gerenciamento.Dto.RegistroDTO;
import com.gerenciamento.Gerenciamento.Infra.TokenService;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Repository.UsuarioRepository;
import jakarta.validation.Valid;
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
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginOutput> login(@RequestBody @Valid AutheticationDTO request) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getSenha());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginOutput(token));
    }

    @PostMapping("/register")
    public ResponseEntity<MessageOutput> registrar(@RequestBody @Valid RegistroDTO request) {
        if(this.repository.findByLogin(request.getLogin()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder().encode(request.getSenha());
        Usuario usuario = new Usuario(request.getLogin(), senhaCriptografada, request.getRole());

        this.repository.save(usuario);

        return ResponseEntity.ok(new MessageOutput("Usuário criado com sucesso"));
    }
}
