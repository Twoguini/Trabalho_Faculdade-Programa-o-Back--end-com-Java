/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Twoguini
 */
public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> list = new ArrayList<>();

    public void insert(PessoaFisica pf) {
        list.add(pf);
    }

    public void alter(PessoaFisica pf) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == pf.getId()) {
                list.set(i, pf);
            }
        }
    }

    public void delete(int id) {
        list.removeIf(p -> p.getId() == id);
    }

    public PessoaFisica get(int id) {
        for (PessoaFisica p : list) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public ArrayList<PessoaFisica> getAll() {
        return list;
    }

    public void keep(String arquivo) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(list);
        out.close();
    }

    public void retrive(String arquivo) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
        list = (ArrayList<PessoaFisica>) in.readObject();
        in.close();
        System.out.printf("Dados de Pessoa Fisica Recuperados%n");
    }
}
