package br.com.mastertech.fastnloud.visual;

import br.com.mastertech.fastnloud.model.*;
import br.com.mastertech.fastnloud.util.*;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class CadastroClientes extends Tela {

    private JRadioButton rbPFisica, rbPJuridica;
    private JTextField txtNome, txtEnder, txtEmail, txtCpf, txtRg, txtCnpj, txtRSocial, txtNEmpr, txtId;

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public CadastroClientes() {
        inicalizarComponentes();
    }

    private void inicalizarComponentes() {

        /* Componentes JPanel */

        JPanel panel1 = initJPanel(700, 480, 700, 480, null, Color.lightGray, null);
        JPanel panel2 = initJPanel(20,  260, 320, 100, new GridLayout(3, 2), Color.gray, BorderFactory.createEtchedBorder());
        JPanel panel3 = initJPanel(360, 260, 320, 100, new GridLayout(3, 2), Color.gray, BorderFactory.createEtchedBorder());

        /* Componentes JRadioButton */

        rbPFisica   = initJRadioButton("Pessoa Fisica",   95,  210, 200, 40, e->pessoaFisicaEvent());
        rbPJuridica = initJRadioButton("Pessoa Juridica", 445, 210, 200, 40, e->pessoaJuridicaEvent());

        /* Componentes JLabel */

        JLabel lTitulo  = initJLabel("Cadastro de Clientes", 250, 25, 380, 30, Color.darkGray, 20);
        JLabel lId      = initJLabel("Codigo",    500, 75,  70, 25, Color.BLACK, 13);
        JLabel lRg      = initJLabel("RG",        40,  330, 90, 25, Color.BLACK, 13);
        JLabel lCpf     = initJLabel("CPF",       40,  300, 90, 25, Color.BLACK, 13);
        JLabel lNome    = initJLabel("Nome",      20,  75,  90, 25, Color.BLACK, 13);
        JLabel lCnpj    = initJLabel("CPNJ",      380, 300, 90, 25, Color.BLACK, 13);
        JLabel lEmail   = initJLabel("Email",     20,  165, 90, 25, Color.BLACK, 13);
        JLabel lEnder   = initJLabel("Endereco",  20,  115, 90, 25, Color.BLACK, 13);
        JLabel lNEmpr   = initJLabel("N. Emp.",   380, 360, 90, 25, Color.BLACK, 13);
        JLabel lRSocial = initJLabel("R. Social", 380, 330, 90, 25, Color.BLACK, 13);

        lTitulo.setFont(new Font("Sans Serif", Font.BOLD, 20));

        /* Componentes JTextField */

        txtId      = initJTextField(550, 75,  50,  25);
        txtRg      = initJTextField(90,  165, 380, 25);
        txtCpf     = initJTextField(90,  165, 380, 25);
        txtNome    = initJTextField(90,  75,  380, 25);
        txtCnpj    = initJTextField(90,  165, 380, 25);
        txtEnder   = initJTextField(90,  115, 380, 25);
        txtEmail   = initJTextField(90,  165, 380, 25);
        txtNEmpr   = initJTextField(90,  165, 380, 25);
        txtRSocial = initJTextField(90,  165, 380, 25);

        // JList
        initJList(clientesList, 500, 115, 175, 75);
        preencherListaClientes();

        /* Inicializa a JFrame */

        janela = new JFrame();

        /* Adiciona os componentes */

        janela.add(panel1);
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(btSalvar);
        panel1.add(btAlterar);
        panel1.add(btRemover);
        panel1.add(btSair);
        panel1.add(lTitulo);
        panel1.add(lId);
        panel1.add(lNome);
        panel1.add(lEnder);
        panel1.add(lEmail);
        panel1.add(txtId);
        panel1.add(txtNome);
        panel1.add(txtEnder);
        panel1.add(txtEmail);
        panel1.add(rbPFisica);
        panel1.add(rbPJuridica);
        panel1.add(clientesList);

        panel2.add(lCpf);
        panel2.add(txtCpf);
        panel2.add(lRg);
        panel2.add(txtRg);

        panel3.add(lCnpj);
        panel3.add(txtCnpj);
        panel3.add(lRSocial);
        panel3.add(txtRSocial);
        panel3.add(lNEmpr);
        panel3.add(txtNEmpr);

        /* Exibe a janela */

        limpar();

        showJFrame("Cadastro de Clientes", 700, 480);
    }

    private void limpar() {

        txtId.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtEnder.setText("");
        txtCnpj.setText("");
        txtRSocial.setText("");
        txtNEmpr.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        rbPFisica.setSelected(false);
        rbPJuridica.setSelected(false);
        txtCpf.setEditable(false);
        txtRg.setEditable(false);
        txtCnpj.setEditable(false);
        txtRSocial.setEditable(false);
        txtNEmpr.setEditable(false);
        clientesListModel.clear();
    }

    private void inserir(Cliente c) {
        clientes.add(c);
    }

    private void remover(int codigo) {

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo() == codigo) {
                clientes.remove(i);
            }
        }
    }

    private void imprimir() {

        limpar();
        preencherListaClientes();
    }

    private void alterar(Cliente c) {

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo() == c.getCodigo()) {
                clientes.set(i, c);
            }
        }
    }

    private Cliente preencherAtributos() {

        Integer cod   = Integer.parseInt(txtId.getText().trim());
        String  nome  = txtNome.getText().trim();
        String  end   = txtEnder.getText().trim();
        String  email = txtEmail.getText().trim();

        Cliente c = null;

        if (rbPFisica.isSelected()) {

            String rg  = txtRg.getText().trim();
            String cpf = txtCpf.getText().trim();

            c = new PessoaFisica(cod, nome, end, email, cpf, rg);

        } else if (rbPJuridica.isSelected()) {

            String cnpj    = txtCnpj.getText().trim();
            String nEmp    = txtNEmpr.getText().trim();
            String rsocial = txtRSocial.getText().trim();

            c = new PessoaJuridica(cod, nome, end, email, cnpj, rsocial, nEmp);
        }

        return c;
    }

    public void btSalvarEvent() {

        Cliente c = preencherAtributos();

        inserir(c);
        imprimir();

        Arquivo.salvar("clientes.data", c);
    }

    public void btAlterarEvent() {
        alterar(preencherAtributos());

        imprimir();
    }

    public void btRemoverEvent() {
        remover(Integer.parseInt(txtId.getText().trim()));

        imprimir();
    }

    private void pessoaFisicaEvent() {

        if (rbPFisica.isSelected()) {

            rbPJuridica.setSelected(false);
            txtRSocial.setEditable(false);
            txtNEmpr.setEditable(false);
            txtCnpj.setEditable(false);
            txtCpf.setEditable(true);
            txtRg.setEditable(true);
        }
    }

    private void pessoaJuridicaEvent() {

        if (rbPJuridica.isSelected()) {

            rbPFisica.setSelected(false);
            txtCpf.setEditable(false);
            txtRg.setEditable(false);
            txtCnpj.setEditable(true);
            txtRSocial.setEditable(true);
            txtNEmpr.setEditable(true);
        }
    }
}
