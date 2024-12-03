package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Dto.DespesaDTO;
import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Despesa;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.DespesaOutput;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Service.CategoriaService;
import com.gerenciamento.Gerenciamento.Service.DespesaService;
import com.gerenciamento.Gerenciamento.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DespesaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DespesaService despesaService;

    @PostMapping("/criar-despesa")
    public ResponseEntity<DespesaOutput> criarDespesa(@RequestBody DespesaDTO request) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(request.getCategoria());
        Usuario usuario = usuarioService.buscarUsuarioPorId(request.getUsuario());
        Despesa despesa = new Despesa(request, usuario, categoria);
        DespesaOutput response = despesaService.cadastrarDespesa(despesa);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/atualizar-despesa/{id}")
    public ResponseEntity<DespesaOutput> atualizarDespesaPorId(@PathVariable Long id, @RequestBody DespesaDTO request) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(request.getCategoria());
        Despesa despesa = new Despesa(request, categoria);
        DespesaOutput response = despesaService.atualizarDespesa(despesa, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar-despesas/{usuarioId}")
    public ResponseEntity<List<DespesaOutput>> listarDespesas(@PathVariable Long usuarioId) {
        List<DespesaOutput> response = despesaService.listarDespesasPorUsuario(usuarioId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar-despesa/{id}")
    public ResponseEntity<MessageOutput> deletarDespesaPorId(@PathVariable Long id) {
        MessageOutput response = despesaService.deletarDespesa(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/despesas/{usuarioId}/mes/{ano}/{mes}")
    public ResponseEntity<List<DespesaOutput>> listarDespesaPorMes(@PathVariable Long usuarioId, @PathVariable int ano, @PathVariable int mes) {
        return ResponseEntity.ok(despesaService.listarDespesasPorMes(ano, mes, usuarioId));
    }

    @GetMapping("/despesas/{usuarioId}/periodo")
    public ResponseEntity<List<DespesaOutput>> listarDespesaPorPeriodo(@PathVariable Long usuarioId, @RequestParam LocalDate dataInicio, @RequestParam LocalDate dataFim) {
        return ResponseEntity.ok(despesaService.listarDespesasPorPeriodo(dataInicio, dataFim, usuarioId));
    }

    @GetMapping("/despesas/{usuarioId}/maiores")
    public ResponseEntity<List<DespesaOutput>> listarMaioresDespesa(@PathVariable Long usuarioId, @RequestParam int limite) {
        return ResponseEntity.ok(despesaService.listarMaioresDespesas(limite, usuarioId));
    }

    @GetMapping("/despesas/{usuarioId}/menores")
    public ResponseEntity<List<DespesaOutput>> listarMenoresDespesa(@PathVariable Long usuarioId, @RequestParam int limite) {
        return ResponseEntity.ok(despesaService.listarMenoresDespesas(limite, usuarioId));
    }
}