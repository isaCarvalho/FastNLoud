package br.com.mastertech.fastnloud.main;

import br.com.mastertech.fastnloud.visual.*;
import javax.swing.*;

public class FastNLoud {

    public static void main(String args[])
    {
        String input;

        while (true)
        {
            input = JOptionPane.showInputDialog("Digite uma opcao:\n1 - Cadastro de Clientes\n2 - Cadastro de Automoveis\n3 - Vendas");
            int resp = Integer.parseInt(input);

            if (resp <= 3 && resp >= 1)
                break;

        }

        switch (Integer.parseInt(input))
        {
            case 1:
                new CadastroClientes();
                break;

            case 2:
                new CadastroAutomoveis();
                break;

            case 3:
                new CadastroVendas();
                break;

            default:
                System.exit(1);
        }
    }
}
