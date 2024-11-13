package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Dto.CategoriaDTO;
import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.CategoriaOutput;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Outputs.UsuarioOutput;
import com.gerenciamento.Gerenciamento.Service.CategoriaService;
import com.gerenciamento.Gerenciamento.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/atualizar-categoria/{id}")
    public ResponseEntity<CategoriaOutput> atualizarCategoria(@RequestBody CategoriaDTO request, @PathVariable Long id) {
        CategoriaOutput response = service.atualizarCategoria(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar-categoria/{id}")
    public ResponseEntity<MessageOutput> deletarCategoria(@PathVariable Long id) {
        MessageOutput response = service.deletarCategoria(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar-categorias")
    public ResponseEntity<List<CategoriaOutput>> listarCategorias() {
        List<CategoriaOutput> response = service.listarCategorias();
        return ResponseEntity.ok(response);
    }
}
