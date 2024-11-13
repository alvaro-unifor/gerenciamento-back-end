package com.gerenciamento.Gerenciamento.Service;

import com.gerenciamento.Gerenciamento.Dto.ReceitaDTO;
import com.gerenciamento.Gerenciamento.Models.Categoria;
import com.gerenciamento.Gerenciamento.Models.Receita;
import com.gerenciamento.Gerenciamento.Outputs.MessageOutput;
import com.gerenciamento.Gerenciamento.Outputs.ReceitaOutput;
import com.gerenciamento.Gerenciamento.Repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    public Receita buscarReceitaPorId(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new RuntimeException("Receita não encontrada"));
    }
}
