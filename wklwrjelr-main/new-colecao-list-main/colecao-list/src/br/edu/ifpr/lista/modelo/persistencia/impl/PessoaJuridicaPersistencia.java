package br.edu.ifpr.lista.modelo.persistencia.impl;

import br.edu.ifpr.lista.modelo.PessoaJuridica;
import br.edu.ifpr.lista.modelo.persistencia.Persistencia;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PessoaJuridicaPersistencia implements Persistencia<PessoaJuridica, String> {
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    @Override
    public int insert(PessoaJuridica pessoa) {
        if (pessoa == null || pessoa.getCnpj() == null) {
            throw new IllegalArgumentException("Pessoa ou CNPJ inválido.");
        }
        for (PessoaJuridica x : pessoasJuridicas) {
            if (x.getCnpj().equals(pessoa.getCnpj())) {
                return 0;
            }
        }
        pessoasJuridicas.add(pessoa);
        return 1;
    }

    @Override
    public int update(String cnpj, PessoaJuridica pessoa) {
        if (pessoa == null || pessoa.getCnpj() == null) {
            throw new IllegalArgumentException("Pessoa ou CNPJ inválido.");
        }
        boolean removed = pessoasJuridicas.removeIf(u -> u.getCnpj().equals(cnpj));
        if (removed) {
            pessoasJuridicas.add(pessoa);
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(String cnpj) {
        if (cnpj == null) {
            throw new IllegalArgumentException("CNPJ não pode ser nulo.");
        }
        boolean removed = pessoasJuridicas.removeIf(u -> u.getCnpj().equals(cnpj));
        return removed ? 1 : 0;
    }

    @Override
    public int delete() {
        int total = pessoasJuridicas.size();
        pessoasJuridicas.clear();
        return total;
    }

    @Override
    public PessoaJuridica select(String cnpj) {
        if (cnpj == null) {
            throw new IllegalArgumentException("CNPJ não pode ser nulo.");
        }
        return pessoasJuridicas.stream()
                .filter(p -> p.getCnpj().equals(cnpj))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        MessageFormat.format("Pessoa jurídica com CNPJ: {0} não encontrada.",cnpj)));
    }

    @Override
    public List<PessoaJuridica> select() {
        return new ArrayList<>(pessoasJuridicas);
    }
}
