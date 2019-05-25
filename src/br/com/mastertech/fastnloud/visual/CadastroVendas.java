package br.com.mastertech.fastnloud.visual;

import br.com.mastertech.fastnloud.model.*;
import br.com.mastertech.fastnloud.util.Arquivo;

import javax.swing.*;
import java.awt.*;

public class CadastroVendas extends Tela {

    public CadastroVendas()
    {
        Cliente.loadClientes();
        Automovel.loadAutomovels();
        inicializarComponentes();
    }

    private void inicializarComponentes()
    {
        // Componentes JPanel
        JPanel panel1 = initJPanel(700, 480, 700, 480, null, new Color(230, 230, 230), null);
        JPanel panel2 = initJPanel(20,  120, 320, 230, new GridLayout(1, 1), new Color(250, 250, 250), BorderFactory.createEtchedBorder());
        JPanel panel3 = initJPanel(360, 120, 320, 230, new GridLayout(1, 1), new Color(250,250,250), BorderFactory.createEtchedBorder());

        // Componentes JLabel
        JLabel titulo     = initJLabel("Vendas de Automoveis", 250, 25, 380, 30, Color.darkGray, 20);
        JLabel clientes   = initJLabel("Clientes",   20,  80, 100, 30, Color.BLACK, 16);
        JLabel automoveis = initJLabel("Automoveis", 360, 80, 100, 30, Color.BLACK, 16);

        preencherListaClientes();
        preencherListaAutomoveis();

        //Inicaliza a Janela
        janela = new JFrame();

        /*Adicao dos Componentes*/
        janela.add(panel1);
        panel2.add(clientesList);
        panel3.add(autoList);
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(btSalvar);
        panel1.add(btSair);
        panel1.add(titulo);
        panel1.add(clientes);
        panel1.add(automoveis);

        showJFrame("Vendas", 700, 480);
    }

    public void btSalvarEvent()
    {
        Venda v = new Venda();

        Cliente c = Cliente.getClientes().get(clientesList.getSelectedIndex());
        Automovel a = Automovel.getAutomovels().get(autoList.getSelectedIndex());

        v.setCliente(c);
        v.setAuto(a);
        v.incrementaCod();

        Arquivo.salvar("vendas.data", v);
    }

    public void btRemoverEvent()
    {

    }

    public void btAlterarEvent()
    {

    }
}
