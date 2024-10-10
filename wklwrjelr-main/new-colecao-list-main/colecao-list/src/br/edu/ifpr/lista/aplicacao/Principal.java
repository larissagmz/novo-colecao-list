package br.edu.ifpr.lista.aplicacao;

import br.edu.ifpr.lista.modelo.PessoaFisica;
import br.edu.ifpr.lista.modelo.PessoaJuridica;
import br.edu.ifpr.lista.modelo.persistencia.impl.PessoaJuridicaPersistencia;

import java.time.LocalDate;
import java.util.ArrayList;

public class Principal {


    public static void main(String[] args) {
        new Principal();
    }

    public Principal() {

        ArrayList<PessoaJuridica> pessoas = new ArrayList<>();

        PessoaJuridica pj1 = new PessoaJuridica("Empresa 1", LocalDate.of(2000, 1, 1), "Rua A", 123, "Bairro A", "Cidade A", "Estado A", "12345678", "11111111000112", "Nome Fantasia 1");

        PessoaJuridica pj2 = new PessoaJuridica("Empresa 2", LocalDate.of(2001, 2, 2), "Rua B", 234, "Bairro B", "Cidade B", "Estado B", "23456789", "22222222000222", "Nome Fantasia 2");

        PessoaJuridica pj3 = new PessoaJuridica("Empresa 3", LocalDate.of(2002, 3, 3), "Rua C", 345, "Bairro C", "Cidade C", "Estado C", "34567890", "33333333000333", "Nome Fantasia 3");

        PessoaJuridica pj4 = new PessoaJuridica("Empresa 4", LocalDate.of(2003, 4, 4), "Rua D", 456, "Bairro D", "Cidade D", "Estado D", "45678901", "44444444000444", "Nome Fantasia 4");

        PessoaJuridica pj5 = new PessoaJuridica("Empresa 5", LocalDate.of(2004, 5, 5), "Rua E", 567, "Bairro E", "Cidade E", "Estado E", "56789012", "55555555000555", "Nome Fantasia 5");

        ArrayList<PessoaFisica> listaPessoaFisica = new ArrayList<>();

        PessoaFisica pf1 = new PessoaFisica("Empresa A", LocalDate.of(1998, 1, 15), "Rua A", 101, "Bairro A", "Cidade A", "Estado A", "12345678", "11122233344");
        PessoaFisica pf2 = new PessoaFisica("Empresa B", LocalDate.of(2001, 2, 20), "Rua B", 202, "Bairro B", "Cidade B", "Estado B", "23456789", "22233344455");
        PessoaFisica pf3 = new PessoaFisica("Empresa C", LocalDate.of(2005, 3, 25), "Rua C", 303, "Bairro C", "Cidade C", "Estado C", "34567890", "33344455566");
        PessoaFisica pf4 = new PessoaFisica("Empresa D", LocalDate.of(2010, 4, 30), "Rua D", 404, "Bairro D", "Cidade D", "Estado D", "45678901", "44455566677");
        PessoaFisica pf5 = new PessoaFisica("Empresa E", LocalDate.of(2015, 5, 5), "Rua E", 505, "Bairro E", "Cidade E", "Estado E", "56789012", "55566677788");
        PessoaFisica pf6 = new PessoaFisica("Empresa F", LocalDate.of(2018, 6, 10), "Rua F", 606, "Bairro F", "Cidade F", "Estado F", "67890123", "66677788899");
        PessoaFisica pf7 = new PessoaFisica("Empresa G", LocalDate.of(2020, 7, 15), "Rua G", 707, "Bairro G", "Cidade G", "Estado G", "78901234", "77788899900");
        PessoaFisica pf8 = new PessoaFisica("Empresa H", LocalDate.of(2022, 8, 20), "Rua H", 808, "Bairro H", "Cidade H", "Estado H", "89012345", "88899900011");
        PessoaFisica pf9 = new PessoaFisica("Empresa I", LocalDate.of(2023, 9, 25), "Rua I", 909, "Bairro I", "Cidade I", "Estado I", "90123456", "99900011122");
        PessoaFisica pf10 = new PessoaFisica("Empresa J", LocalDate.of(2024, 10, 30), "Rua J", 1000, "Bairro J", "Cidade J", "Estado J", "01234567", "00011122233");



        PessoaJuridicaPersistencia persistencia = new PessoaJuridicaPersistencia();


      persistencia.insert(pj1);
      persistencia.insert(pj2);
      persistencia.insert(pj3);
      persistencia.insert(pj4);
      persistencia.insert(pj5);

        System.out.println(persistencia.select());
    }
}