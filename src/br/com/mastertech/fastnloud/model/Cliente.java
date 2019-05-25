package br.com.mastertech.fastnloud.model;

import br.com.mastertech.fastnloud.util.*;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Cliente implements Serializable {

    final static private long serialVersionID = 1;

    private int codigo;
    private String nome;
    private String endereco;
    private String email;

    static private List<Cliente> clientes = new ArrayList<>();

    Cliente(int codigo, String nome, String endereco, String email)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    public static void loadClientes()
    {
        Cliente c = (Cliente) Arquivo.ler("clientes.data");

        if (c != null)
            Cliente.clientes.add(c);
    }

    public static List<Cliente> getClientes() {
        return Cliente.clientes;
    }

    public int getCodigo() { return this.codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
