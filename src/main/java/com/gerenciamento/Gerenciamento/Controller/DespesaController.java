package com.gerenciamento.Gerenciamento.Controller;

import com.gerenciamento.Gerenciamento.Dto.CategoriaDTO;
import com.gerenciamento.Gerenciamento.Dto.DespesaDTO;
import com.gerenciamento.Gerenciamento.Dto.ReceitaDTO;
import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Despesa;
import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Models.Usuario;
import com.gerenciamento.Gerenciamento.Outputs.CategoriaOutput;
import com.gerenciamento.Gerenciamento.Outputs.DespesaOutput;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Service.CategoriaService;
import com.gerenciamento.Gerenciamento.Service.DespesaService;
import com.gerenciamento.Gerenciamento.Service.ReceitaService;
import com.gerenciamento.Gerenciamento.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Usuario usuario = usuarioService.buscarUsuarioPorId(request.getCategoria());


        Despesa despesa = new Despesa(request, usuario, categoria);

        DespesaOutput response = despesaService.cadastrarReceita(despesa);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/atualizar-despesa/{id}")
    public ResponseEntity<DespesaOutput> atualizarDespesaPorId(@PathVariable Long id, @RequestBody DespesaDTO request) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(request.getCategoria());
        Despesa despesa = new Despesa(request, categoria);

        DespesaOutput response = despesaService.atualizarDespesa(despesa, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar-despesas")
    public ResponseEntity<List<DespesaOutput>> listarReceitas() {
        List<DespesaOutput> response = despesaService.listarReceitas();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar-despesa/{id}")
    public ResponseEntity<MessageOutput> deletarReceitaPorId(@PathVariable Long id) {
        MessageOutput response = despesaService.deletarReceita(id);
        return ResponseEntity.ok(response);
    }
}
