package br.com.mastertech.fastnloud.model;

import java.io.Serializable;

public class Venda implements Serializable {

    final static private long serialVersionID = 1;

    private Automovel auto;
    private Cliente cliente;
    private int cod_venda;

    public void incrementaCod()
    {
        this.cod_venda += 1;
    }

    public void decrementaCod()
    {
        this.cod_venda -= 1;
    }

    public int getCod_venda()
    {
        return cod_venda;
    }

    public Automovel getAuto() {
        return auto;
    }

    public void setAuto(Automovel auto) {
        this.auto = auto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
