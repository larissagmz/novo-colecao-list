package br.edu.ifpr.lista.modelo;
import br.edu.ifpr.lista.Utils.Utils;
import java.time.LocalDate;
import java.util.Objects;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String nomeFantasia;

    public PessoaJuridica() { super(); }





    public PessoaJuridica(String nome, LocalDate nascimento, String nomeRua, Integer numero, String bairro, String cidade, String estado, String CEP, String cnpj, String nomeFantasia) {
        super(nome, nascimento, nomeRua, numero, bairro, cidade, estado, CEP);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }


    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }


    @Override
    public String toString() {
        return "PessoaJurídica: cnpj = " + Utils.fomatCnpj(cnpj) + ", nomeFantasia = " + nomeFantasia + super.toString() ;
    }
    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;
        PessoaJuridica outraPessoa = (PessoaJuridica) obj;
        return Objects.equals(cnpj, outraPessoa.cnpj) && Objects.equals(nomeFantasia, outraPessoa.nomeFantasia);
    }








}
