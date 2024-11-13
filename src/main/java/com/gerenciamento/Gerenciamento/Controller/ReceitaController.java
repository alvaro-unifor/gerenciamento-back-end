package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Dto.ReceitaDTO;
import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Service.CategoriaService;
import com.gerenciamento.Gerenciamento.Service.ReceitaService;
import com.gerenciamento.Gerenciamento.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReceitaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ReceitaService receitaService;


    @PostMapping("/criar-receita")
    public ResponseEntity<ReceitaOutput> criarReceita(@RequestBody ReceitaDTO request) {

        Usuario usuario = usuarioService.buscarUsuarioPorId(request.getUsuario());
        Categoria categoria = categoriaService.buscarCategoriaPorId(request.getCategoria());

        Receita receita = new Receita(request, usuario, categoria);

        ReceitaOutput response = receitaService.cadastrarReceita(receita);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/atualizar-receita/{id}")
    public ResponseEntity<ReceitaOutput> atualizarReceitaPorId(@PathVariable Long id, @RequestBody ReceitaDTO request) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(request.getCategoria());
        Receita receita = new Receita(request, categoria);

        ReceitaOutput response = receitaService.atualizarReceita(receita, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar-receitas")
    public ResponseEntity<List<ReceitaOutput>> listarReceitas() {
        List<ReceitaOutput> response = receitaService.listarReceitas();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar-receita/{id}")
    public ResponseEntity<MessageOutput> deletarReceitaPorId(@PathVariable Long id) {
        MessageOutput response = receitaService.deletarReceita(id);
        return ResponseEntity.ok(response);
    }
}
