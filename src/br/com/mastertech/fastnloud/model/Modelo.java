package br.com.mastertech.fastnloud.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Modelo implements Serializable {

    final static private long serialVersionID = 1;

    private String nome;
    private String versao;
    private ArrayList<Automovel> automoveis = new ArrayList<>();

    public void adicionarVeiculos(Automovel auto)
    {
        automoveis.add(auto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}
