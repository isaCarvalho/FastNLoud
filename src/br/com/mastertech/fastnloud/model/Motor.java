package br.com.mastertech.fastnloud.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Motor implements Serializable {

    final static private long serialVersionID = 1;

    private String nome;
    private Integer codigo;
    private int transmissao;
    private String combustivel;

    private SistemaEletrico sistema;
    private ArrayList<Automovel> automoveis = new ArrayList<>();

    public void inserirAutomoveis(Automovel auto)
    {
        automoveis.add(auto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer cilindrada) {
        this.codigo = cilindrada;
    }

    public int getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(int transmissao) {
        this.transmissao = transmissao;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public SistemaEletrico getSistema() {
        return sistema;
    }

    public void setSistema(SistemaEletrico sistema) {
        this.sistema = sistema;
    }
}
