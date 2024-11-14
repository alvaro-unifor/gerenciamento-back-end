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
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ReceitaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/criar-receita")
    public ResponseEntity<ReceitaOutput> criarReceita(@Valid @RequestBody ReceitaDTO request) {

        Categoria categoria = categoriaService.buscarCategoriaPorId(request.getCategoria());
        Usuario usuario = usuarioService.buscarUsuarioPorId(request.getUsuario());

        Receita receita = new Receita(request, usuario, categoria);

        return ResponseEntity.ok(receitaService.cadastrarReceita(receita));
    }

    @PutMapping("/atualizar-receita/{id}")
    public ResponseEntity<ReceitaOutput> atualizarReceitaPorId(@PathVariable Long id, @Valid @RequestBody ReceitaDTO request) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(request.getCategoria());
        Receita receita = new Receita(request, categoria);

        return ResponseEntity.ok(receitaService.atualizarReceita(receita, id));
    }

    @GetMapping("/listar-receitas")
    public ResponseEntity<List<ReceitaOutput>> listarReceitas() {
        return ResponseEntity.ok(receitaService.listarReceitas());
    }

    @DeleteMapping("/deletar-receita/{id}")
    public ResponseEntity<MessageOutput> deletarReceitaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(receitaService.deletarReceita(id));
    }

    @GetMapping("/receitas/mes/{ano}/{mes}")
    public ResponseEntity<List<ReceitaOutput>> listarReceitasPorMes(@PathVariable int ano, @PathVariable int mes) {
        return ResponseEntity.ok(receitaService.listarReceitasPorMes(ano, mes));
    }

    @GetMapping("/receitas/periodo")
    public ResponseEntity<List<ReceitaOutput>> listarReceitasPorPeriodo(@RequestParam LocalDate dataInicio, @RequestParam LocalDate dataFim) {
        return ResponseEntity.ok(receitaService.listarReceitasPorPeriodo(dataInicio, dataFim));
    }

    @GetMapping("/receitas/maiores")
    public ResponseEntity<List<ReceitaOutput>> listarMaioresReceitas(@RequestParam int limite) {
        return ResponseEntity.ok(receitaService.listarMaioresReceitas(limite));
    }

    @GetMapping("/receitas/menores")
    public ResponseEntity<List<ReceitaOutput>> listarMenoresReceitas(@RequestParam int limite) {
        return ResponseEntity.ok(receitaService.listarMenoresReceitas(limite));
    }
}
