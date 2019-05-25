package br.com.mastertech.fastnloud.util;

import java.io.*;

public class Arquivo {

    public static void salvar(String nome, Object o) {
        try {
            FileOutputStream arq   = new FileOutputStream(nome);
            ObjectOutputStream obj = new ObjectOutputStream(arq);

            obj.writeObject(o);
            obj.flush();
            obj.close();

            arq.flush();
            arq.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Object ler(String nome) {

        Object o = null;

        try {
            FileInputStream arq   = new FileInputStream(nome);
            ObjectInputStream obj = new ObjectInputStream(arq);

            o = obj.readObject();

            obj.close();
            arq.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return o;
    }
}
