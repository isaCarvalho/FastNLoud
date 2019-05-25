package br.com.mastertech.fastnloud.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaEletrico implements Serializable {

    final static private long serialVersionID = 1;

    private int ignicao;
    private Double bateria;
    private String farol;
    private ArrayList<Motor> motors = new ArrayList<>();

    public void inserirMotores(Motor m) {
        motors.add(m);
    }

    public int getIgnicao() {
        return ignicao;
    }

    public void setIgnicao(int ignicao) {
        this.ignicao = ignicao;
    }

    public Double getBateria() {
        return bateria;
    }

    public void setBateria(Double bateria) {
        this.bateria = bateria;
    }

    public String getFarol() {
        return farol;
    }

    public void setFarol(String farol) {
        this.farol = farol;
    }
}
