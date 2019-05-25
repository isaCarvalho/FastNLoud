package br.com.mastertech.fastnloud.model;

import br.com.mastertech.fastnloud.util.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Automovel implements Serializable {

    final static private long serialVersionID = 1;

    private int codigo;
    private String chassi;
    private String cor;
    private Double preco;
    private Motor motor;
    private Modelo modelo;

    private static List<Automovel> automovels = new ArrayList<>();

    public static List<Automovel> getAutomovels() {
        return Automovel.automovels;
    }

    public static void loadAutomovels() {
        Automovel a = (Automovel) Arquivo.ler("automovels.data");

        if (a != null)
            Automovel.setAutomovels(a);
    }

    public static void setAutomovels(Automovel a) {
        Automovel.automovels.add(a);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
