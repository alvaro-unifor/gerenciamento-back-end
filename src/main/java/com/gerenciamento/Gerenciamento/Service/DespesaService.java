package com.gerenciamento.Gerenciamento.Service;

import com.gerenciamento.Gerenciamento.Exception.EntidadeNaoEncontradaException;
import com.gerenciamento.Gerenciamento.Models.Despesa;
import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Outputs.DespesaOutput;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Repository.DespesaRepository;
import com.gerenciamento.Gerenciamento.Repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class DespesaService {
    @Autowired
    DespesaRepository repository;

    public DespesaOutput cadastrarDespesa(Despesa input) {
        return new DespesaOutput(repository.save(input));
    }

    public DespesaOutput atualizarDespesa(Despesa despesaInput, Long id){
        Despesa despesa = buscarReceitaPorId(id);
        despesa.setCategoria(despesaInput.getCategoria());
        despesa.setData(despesaInput.getData());
        despesa.setDescricao(despesaInput.getDescricao());
        despesa.setValor(despesaInput.getValor());

        return new DespesaOutput(repository.save(despesa));
    }

    public MessageOutput deletarDespesa(Long id){
        Despesa despesa = buscarReceitaPorId(id);
        repository.delete(despesa);
        return new MessageOutput("Despesa deletada com sucesso");
    }

    public List<DespesaOutput> listarDespesas() {
        List<Despesa> despesas = repository.findAll();
        List<DespesaOutput> lista = new ArrayList<>();
        for (Despesa despesa: despesas) {
            lista.add(new DespesaOutput(despesa));
        }
        return lista;
    }

    public List<DespesaOutput> listarDespesasPorMes(int ano, int mes) {
        LocalDate dataInicial = YearMonth.of(ano, mes).atDay(1);
        LocalDate dataFInal = YearMonth.of(ano, mes).atEndOfMonth();
        List<Despesa> despesas = repository.findByDataBetween(dataInicial, dataFInal);
        List<DespesaOutput> lista = new ArrayList<>();
        for (Despesa despesa: despesas) {
            lista.add(new DespesaOutput(despesa));
        }
        return lista;
    }

    public List<DespesaOutput> listarDespesasPorPeriodo(LocalDate dataInicial, LocalDate dataFInal) {
        List<Despesa> despesas = repository.findByDataBetween(dataInicial, dataFInal);
        List<DespesaOutput> lista = new ArrayList<>();
        for (Despesa despesa: despesas) {
            lista.add(new DespesaOutput(despesa));
        }
        return lista;
    }

    public List<DespesaOutput> listarMaioresDespesas(int limite) {
        List<Despesa> despesas = repository.findByOrderByValorDesc(PageRequest.of(0, limite));
        List<DespesaOutput> lista = new ArrayList<>();
        for (Despesa despesa: despesas) {
            lista.add(new DespesaOutput(despesa));
        }
        return lista;
    }

    public List<DespesaOutput> listarMenoresDespesas(int limite) {
        List<Despesa> despesas = repository.findByOrderByValorAsc(PageRequest.of(0, limite));
        List<DespesaOutput> lista = new ArrayList<>();
        for (Despesa despesa: despesas) {
            lista.add(new DespesaOutput(despesa));
        }
        return lista;
    }

    public List<DespesaOutput> listarDespesasPorUsuario(Long usuarioId) {
        List<Despesa> despesas = repository.findByUsuarioId(usuarioId);
        List<DespesaOutput> lista = new ArrayList<>();
        for (Despesa despesa : despesas) {
            lista.add(new DespesaOutput(despesa));
        }
        return lista;
    }

    public Despesa buscarReceitaPorId(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Despesa não encontrada"));
    }
}
