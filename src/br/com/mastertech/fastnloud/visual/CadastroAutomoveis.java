package br.com.mastertech.fastnloud.visual;

import br.com.mastertech.fastnloud.model.*;
import br.com.mastertech.fastnloud.util.*;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class CadastroAutomoveis extends Tela {

    private JRadioButton rbMoto, rbCarro, rbVan;
    private JTextField txtChassi, txtCor, txtNModelo, txtVModelo, txtMotor, txtPreco, txtCodigo, txtTransmissao, txtCombustivel, txtBateria, txtIgnicao, txtFarol;

    private static ArrayList<Automovel> automovels = new ArrayList<>();

    public CadastroAutomoveis() {
        inicalizarComponentes();
    }

    private void inicalizarComponentes() {

        /* Componentes JPanel */

        JPanel panel1 = initJPanel(700, 480, 700, 480, null, new Color(230, 230, 230), null);

        /* Componentes JRadioButton */

        rbVan   = initJRadioButton("Van",  370, 315, 100, 25, e->vanEvent());
        rbMoto  = initJRadioButton("Moto", 230, 315, 100, 25, e->motoEvent());
        rbCarro = initJRadioButton("Carro",90,  315, 100, 25, e->carroEvent());

        /* Componentes JLabel */

        JLabel lTitulo = initJLabel("Cadastro de Automoveis", 235, 25, 380, 30, Color.DARK_GRAY, 20);
        JLabel lChassi = initJLabel("Chassi", 20,  75,  50, 25, Color.BLACK, 13);
        JLabel lCor    = initJLabel("Cor",    20,  115, 50, 25, Color.BLACK, 13);
        JLabel lNModelo = initJLabel("Modelo", 20,  195, 50, 25, Color.BLACK, 13);
        JLabel lVModelo = initJLabel("Versao", 270, 195, 50, 25, Color.BLACK, 13);
        JLabel lCombustivel = initJLabel("Comb.", 270, 155, 50, 25, Color.BLACK, 13);
        JLabel lMotor  = initJLabel("Motor",  20,  155, 50, 25, Color.BLACK, 13);
        JLabel lIgnicao = initJLabel("Ignicao", 20, 235, 50, 25, Color.BLACK, 13);
        JLabel lBateria = initJLabel("Bateria", 270, 235, 50, 25, Color.BLACK, 13);
        JLabel lFarol = initJLabel("Farol", 20, 275, 50, 25, Color.BLACK, 13);
        JLabel lPreco  = initJLabel("Preco",  500, 115,  50, 25, Color.BLACK, 13);
        JLabel lTransmissao = initJLabel("Trans.", 500, 150, 50, 40, Color.BLACK, 13);
        JLabel lCodigo = initJLabel("Codigo", 500, 70, 50, 40, Color.BLACK, 13);

        lTitulo.setFont(new Font("Sans Serif", Font.BOLD, 20));

        /* Componentes JTextField */

        txtCor    = initJTextField(90,  115, 380, 25);
        txtCodigo = initJTextField(550, 75, 80, 25);
        txtPreco  = initJTextField(550, 115,  80,  25);
        txtTransmissao = initJTextField(550, 155, 80, 25);
        txtMotor  = initJTextField(90,  155, 140, 25);
        txtCombustivel = initJTextField(330, 155, 140, 25);
        txtNModelo = initJTextField(90,  195, 140, 25);
        txtVModelo = initJTextField(330, 195, 140, 25);
        txtIgnicao = initJTextField(90, 235, 140, 25);
        txtBateria = initJTextField(330, 235, 140, 25);
        txtFarol = initJTextField(90, 275, 380, 25);
        txtChassi = initJTextField(90,  75,  380, 25);

        //Componente JList
        initJList(autoList, 500, 205, 175, 130);
        preencherListaAutomoveis();

        /* Inicializa a JFrame */

        janela = new JFrame();

        /* Adiciona os componentes */

        janela.add(panel1);
        panel1.add(autoList);
        panel1.add(txtChassi);
        panel1.add(txtCor);
        panel1.add(txtMotor);
        panel1.add(txtNModelo);
        panel1.add(txtVModelo);
        panel1.add(txtPreco);
        panel1.add(txtTransmissao);
        panel1.add(txtCodigo);
        panel1.add(txtCombustivel);
        panel1.add(txtBateria);
        panel1.add(txtFarol);
        panel1.add(txtIgnicao);
        panel1.add(lTitulo);
        panel1.add(lChassi);
        panel1.add(lCor);
        panel1.add(lNModelo);
        panel1.add(lVModelo);
        panel1.add(lMotor);
        panel1.add(lPreco);
        panel1.add(lTransmissao);
        panel1.add(lCodigo);
        panel1.add(lCombustivel);
        panel1.add(lIgnicao);
        panel1.add(lBateria);
        panel1.add(lFarol);
        panel1.add(rbCarro);
        panel1.add(rbMoto);
        panel1.add(rbVan);
        panel1.add(btSalvar);
        panel1.add(btAlterar);
        panel1.add(btRemover);
        panel1.add(btSair);

        /* Exibe a janela */

        showJFrame("Cadastro de Automoveis", 700, 480);
    }

    private void inserir(Automovel a) {
        automovels.add(a);
        limpar();
    }

    private void alterar(Automovel auto) {

        for (int i = 0; i < automovels.size(); i++) {
            if (automovels.get(i).getChassi().equals(auto.getChassi()))
                automovels.set(i, auto);
        }

        limpar();
        imprimir();
    }

    private void remover(Integer codigo) {

        for (int i = 0; i < automovels.size(); i++) {
            if (automovels.get(i).getCodigo() == codigo)
                automovels.remove(i);
        }
    }

    private Automovel preencherCampos() {

        Automovel a = null;

        SistemaEletrico se = new SistemaEletrico();

        se.setBateria(Double.parseDouble(txtBateria.getText().trim()));
        se.setFarol(txtFarol.getText().trim());
        se.setIgnicao(Integer.parseInt(txtIgnicao.getText().trim()));

        Motor m = new Motor();

        m.setSistema(se);
        m.setNome(txtMotor.getText().trim());
        m.setCombustivel(txtCombustivel.getText().trim());
        m.setCodigo(Integer.parseInt(txtCodigo.getText().trim()));
        m.setTransmissao(Integer.parseInt(txtTransmissao.getText().trim()));
        se.inserirMotores(m);

        Modelo model = new Modelo();

        model.setNome(txtNModelo.getText().trim());
        model.setVersao(txtVModelo.getText().trim());

        if (rbCarro.isSelected()) {

            a = new Carro();

            a.setMotor(m);
            a.setModelo(model);
            a.setCor(txtCor.getText().trim());
            a.setChassi(txtChassi.getText().trim());
            a.setPreco(Double.parseDouble(txtPreco.getText().trim()));

        } else if (rbMoto.isSelected()) {

            a = new Moto();

            a.setMotor(m);
            a.setModelo(model);
            a.setCor(txtCor.getText().trim());
            a.setChassi(txtChassi.getText().trim());
            a.setPreco(Double.parseDouble(txtPreco.getText().trim()));

        } else if (rbVan.isSelected()) {

            a = new Van();

            a.setMotor(m);
            a.setModelo(model);
            a.setCor(txtCor.getText().trim());
            a.setChassi(txtChassi.getText().trim());
            a.setPreco(Double.parseDouble(txtPreco.getText().trim()));
        }

        model.adicionarVeiculos(a);
        m.inserirAutomoveis(a);

        return a;
    }

    private void imprimir() {
        limpar();
        preencherListaAutomoveis();
    }

    private void limpar() {

        txtCor.setText("");
        txtPreco.setText("");
        txtTransmissao.setText("");
        txtCodigo.setText("");
        txtMotor.setText("");
        txtCombustivel.setText("");
        txtNModelo.setText("");
        txtVModelo.setText("");
        txtIgnicao.setText("");
        txtBateria.setText("");
        txtFarol.setText("");
        txtChassi.setText("");
        rbMoto.setSelected(false);
        rbCarro.setSelected(false);
        rbVan.setSelected(false);
    }

    public void btSalvarEvent() {

        Automovel a = preencherCampos();

        inserir(a);
        imprimir();

        Arquivo.salvar("automovels.data", a);
    }

    public void btRemoverEvent() {
        remover(Integer.parseInt(txtCodigo.getText()));
        imprimir();
    }

    public void btAlterarEvent() {
        alterar(preencherCampos());
        imprimir();
    }

    private void carroEvent() {

        if (rbCarro.isSelected()) {

            rbMoto.setSelected(false);
            rbVan.setSelected(false);
        }
    }

    private void motoEvent() {

        if (rbMoto.isSelected()) {

            rbVan.setSelected(false);
            rbCarro.setSelected(false);
        }
    }

    private void vanEvent() {

        if (rbVan.isSelected()) {

            rbCarro.setSelected(false);
            rbMoto.setSelected(false);
        }
    }
}
