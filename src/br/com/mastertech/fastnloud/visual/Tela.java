package br.com.mastertech.fastnloud.visual;

import br.com.mastertech.fastnloud.model.Automovel;
import br.com.mastertech.fastnloud.model.Cliente;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;

public abstract class Tela extends JPanel {

    JFrame janela;

    //static JTextArea txtaLista;

    public JButton btSair    = initJButton("Sair",  585, 400, 90, 30, e->btSairEvent());
    public JButton btSalvar  = initJButton("Salvar",  20,  400, 90, 30, e->btSalvarEvent());
    public JButton btAlterar = initJButton("Alterar", 200, 400, 90, 30, e->btAlterarEvent());
    public JButton btRemover = initJButton("Remover", 380, 400, 90, 30, e->btRemoverEvent());

    public DefaultListModel<String> autoListModel = new DefaultListModel<>();
    public DefaultListModel<String> clientesListModel = new DefaultListModel<>();

    public JList<String> autoList = new JList<>(autoListModel);
    public JList<String> clientesList = new JList<>(clientesListModel);

    public abstract void btSalvarEvent();
    public abstract void btAlterarEvent();
    public abstract void btRemoverEvent();

    public void initJList(JList<String> lista, int x, int y, int weight, int height)
    {
        lista.setBorder(BorderFactory.createEtchedBorder());
        lista.setAutoscrolls(true);
        lista.setBounds(x, y, weight, height);
    }

    public void preencherListaClientes()
    {
        for (Cliente c : Cliente.getClientes())
            clientesListModel.addElement(c.getNome());
    }

    public void preencherListaAutomoveis()
    {
        for (Automovel a : Automovel.getAutomovels())
            autoListModel.addElement(a.getModelo().getNome());
    }

    private void btSairEvent() { janela.dispose(); }

    void showJFrame(String title, int x, int y) {

        janela.setTitle(title);
        janela.setSize(x, y);
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton initJButton(String title, int x, int y, int weight, int height, ActionListener action) {

        JButton bt = new JButton();

        bt.setText(title);
        bt.setBounds(x,y,weight,height);
        bt.addActionListener(action);

        return bt;
    }

    JRadioButton initJRadioButton(String title, int x, int y, int weight, int heigth, ActionListener action) {

        JRadioButton rb = new JRadioButton(title);

        rb.setVisible(true);
        rb.setSelected(false);
        rb.addActionListener(action);
        rb.setBounds(x, y, weight, heigth);
        rb.setBackground(Color.lightGray);

        return rb;
    }

    JTextField initJTextField(int x, int y, int weight, int height) {

        JTextField txt = new JTextField();

        txt.setFocusable(true);
        txt.setForeground(Color.black);
        txt.setBounds(x, y, weight, height);
        txt.setFont(new Font("Sans Serif", Font.PLAIN, 14));

        return txt;
    }

    JLabel initJLabel(String title, int x, int y, int weight, int height, Color color, int fontSize) {

        JLabel label = new JLabel(title);

        label.setVisible(true);
        label.setForeground(color);
        label.setBounds(x, y, weight, height);
        label.setFont(new Font("Sans Serif", Font.PLAIN, fontSize));

        return label;
    }

    JPanel initJPanel(int x, int y, int weight, int height, LayoutManager layout, Color color, Border border) {

        JPanel panel = new JPanel();

        panel.setLayout(layout);
        panel.setBorder(border);
        panel.setBackground(color);
        panel.setBounds(x,y,weight,height);

        return panel;
    }
}
