package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.CategoriaOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Outputs.UsuarioOutput;
import com.gerenciamento.Gerenciamento.Service.CategoriaService;
import com.gerenciamento.Gerenciamento.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoriaController {
    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar-categoria")
    public ResponseEntity<CategoriaOutput> cadastrarCategoria(@RequestBody Categoria request) {
        CategoriaOutput response = service.cadastrarCategoria(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar-categorias")
    public ResponseEntity<List<CategoriaOutput>> listarCategorias() {
        List<CategoriaOutput> response = service.listarCategorias();
        return ResponseEntity.ok(response);
    }
}
