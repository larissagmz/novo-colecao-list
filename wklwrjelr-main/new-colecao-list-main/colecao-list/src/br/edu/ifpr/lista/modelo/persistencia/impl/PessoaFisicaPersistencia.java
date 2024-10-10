package br.edu.ifpr.lista.modelo.persistencia.impl;

import br.edu.ifpr.lista.modelo.PessoaFisica;
import br.edu.ifpr.lista.modelo.persistencia.Persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PessoaFisicaPersistencia implements Persistencia<PessoaFisica, String> {
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();

    @Override
    public int insert(PessoaFisica pessoa) {
        if (pessoa == null || pessoa.getCpf() == null) {
            throw new IllegalArgumentException("Pessoa ou CPF inválido.");
        }
        for (PessoaFisica x : pessoasFisicas) {
            if (x.getCpf().equals(pessoa.getCpf())) {
                return 0;
            }
        }
        pessoasFisicas.add(pessoa);
        return 1;
    }

    @Override
    public int update(String cpf, PessoaFisica pessoa) {
        if (pessoa == null || pessoa.getCpf() == null) {
            throw new IllegalArgumentException("Pessoa ou CPF inválido.");
        }
        boolean removed = pessoasFisicas.removeIf(u -> u.getCpf().equals(cpf));
        if (removed) {
            pessoasFisicas.add(pessoa);
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        boolean removed = pessoasFisicas.removeIf(u -> u.getCpf().equals(cpf));
        return removed ? 1 : 0;
    }

    @Override
    public int delete() {
        int total = pessoasFisicas.size();
        pessoasFisicas.clear();
        return total;
    }

    @Override
    public PessoaFisica select(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        return pessoasFisicas.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Pessoa com CPF: " + cpf + " não encontrada."));
    }

    @Override
    public List<PessoaFisica> select() {
        return new ArrayList<>(pessoasFisicas);
    }
}
