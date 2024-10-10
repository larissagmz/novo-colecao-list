package br.edu.ifpr.lista.modelo.persistencia;

import br.edu.ifpr.lista.modelo.PessoaFisica;

import java.util.List;

public interface Persistencia<T, K> {


    public int insert(T t);

    public  int update(K k, T t);

    public int delete(K k);

    public int delete();

    public T select(K k);

    public List<T> select();
}
