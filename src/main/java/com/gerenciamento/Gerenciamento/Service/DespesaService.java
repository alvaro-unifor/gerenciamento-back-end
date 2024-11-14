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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DespesaService {
    @Autowired
    DespesaRepository repository;

    public DespesaOutput cadastrarReceita(Despesa input) {
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

    public MessageOutput deletarReceita(Long id){
        Despesa despesa = buscarReceitaPorId(id);
        repository.delete(despesa);
        return new MessageOutput("Despesa deletada com sucesso");
    }

    public List<DespesaOutput> listarReceitas() {
        List<Despesa> despesas = repository.findAll();
        List<DespesaOutput> lista = new ArrayList<>();
        for (Despesa despesa: despesas) {
            lista.add(new DespesaOutput(despesa));
        }
        return lista;
    }

    public Despesa buscarReceitaPorId(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Despesa não encontrada"));
    }
}
