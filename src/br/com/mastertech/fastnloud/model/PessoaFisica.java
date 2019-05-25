package br.com.mastertech.fastnloud.model;

public class PessoaFisica extends Cliente {

    private String cpf;
    private String rg;

    public PessoaFisica(int codigo, String nome, String endereco, String email, String cpf, String rg)
    {
        super(codigo, nome, endereco, email);
        this.cpf = cpf;
        this.rg = rg;
    }
    @Override
    public int getCodigo() {
        return super.getCodigo();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
