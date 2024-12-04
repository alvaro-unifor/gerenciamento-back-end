package com.gerenciamento.Gerenciamento.Service;

import com.gerenciamento.Gerenciamento.Dto.ReceitaDTO;
import com.gerenciamento.Gerenciamento.Exception.EntidadeNaoEncontradaException;
import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository repository;

    public ReceitaOutput cadastrarReceita(Receita input) {
        return new ReceitaOutput(repository.save(input));
    }

    public ReceitaOutput atualizarReceita(Receita receitaInput, Long id){
        Receita receita = buscarReceitaPorId(id);

        receita.setCategoria(receitaInput.getCategoria());
        receita.setData(receitaInput.getData());
        receita.setDescricao(receitaInput.getDescricao());
        receita.setValor(receitaInput.getValor());

        return new ReceitaOutput(repository.save(receita));
    }

    public MessageOutput deletarReceita(Long id){
        Receita receita = buscarReceitaPorId(id);
        repository.delete(receita);
        return new MessageOutput("Receita deletada com sucesso");
    }

    public List<ReceitaOutput> listarReceitas() {
        List<Receita> receitas = repository.findAll();
        List<ReceitaOutput> lista = new ArrayList<>();
        for (Receita receita: receitas) {
            lista.add(new ReceitaOutput(receita));
        }
        return lista;
    }

    public List<ReceitaOutput> listarReceitasPorMes(int ano, int mes, Long usuarioId) {
        LocalDate dataInicial = YearMonth.of(ano, mes).atDay(1);
        LocalDate dataFinal = YearMonth.of(ano, mes).atEndOfMonth();
        List<Receita> receitas = repository.findByUsuarioIdAndDataBetween(usuarioId, dataInicial, dataFinal);
        List<ReceitaOutput> lista = new ArrayList<>();
        for (Receita receita: receitas) {
            lista.add(new ReceitaOutput(receita));
        }
        return lista;
    }

    public List<ReceitaOutput> listarReceitasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, Long usuarioId) {
        List<Receita> receitas = repository.findByUsuarioIdAndDataBetween(usuarioId, dataInicial, dataFinal);
        List<ReceitaOutput> lista = new ArrayList<>();
        for (Receita receita: receitas) {
            lista.add(new ReceitaOutput(receita));
        }
        return lista;
    }

    public List<ReceitaOutput> listarMaioresReceitas(int limite, Long usuarioId) {
        List<Receita> receitas = repository.findByUsuarioIdOrderByValorDesc(usuarioId, PageRequest.of(0, limite));
        List<ReceitaOutput> lista = new ArrayList<>();
        for (Receita receita: receitas) {
            lista.add(new ReceitaOutput(receita));
        }
        return lista;
    }

    public List<ReceitaOutput> listarMenoresReceitas(int limite, Long usuarioId) {
        List<Receita> receitas = repository.findByUsuarioIdOrderByValorAsc(usuarioId, PageRequest.of(0, limite));
        List<ReceitaOutput> lista = new ArrayList<>();
        for (Receita receita: receitas) {
            lista.add(new ReceitaOutput(receita));
        }
        return lista;
    }

    public List<ReceitaOutput> listarReceitasPorUsuario(Long usuarioId) {
        List<Receita> receitas = repository.findByUsuarioId(usuarioId);
        List<ReceitaOutput> lista = new ArrayList<>();
        for (Receita receita : receitas) {
            lista.add(new ReceitaOutput(receita));
        }
        return lista;
    }

    public Receita buscarReceitaPorId(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Receita não encontrada"));
    }
}