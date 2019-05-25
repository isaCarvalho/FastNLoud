package br.com.mastertech.fastnloud.model;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String razaoSocial;
    private String nomeEmpresarial;

    public PessoaJuridica(int codigo, String nome, String end, String email, String cnpj, String rs, String ne)
    {
        super(codigo, nome, end, email);
        this.cnpj = cnpj;
        this.razaoSocial = rs;
        this.nomeEmpresarial = ne;
    }

    @Override
    public int getCodigo() {
        return super.getCodigo();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    public void setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
