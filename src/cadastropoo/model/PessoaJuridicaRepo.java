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
public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> list = new ArrayList<>();

    public void insert(PessoaJuridica pj) {
        list.add(pj);
    }

    public void alter(PessoaJuridica pj) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == pj.getId()) {
                list.set(i, pj);
            }
        }
    }

    public void delete(int id) {
        list.removeIf(p -> p.getId() == id);
    }

    public PessoaJuridica get(int id) {
        for (PessoaJuridica p : list) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public ArrayList<PessoaJuridica> getAll() {
        return list;
    }

    public void keep(String arquivo) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(list);
        out.close();
    }

    public void retrive(String arquivo) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
        list = (ArrayList<PessoaJuridica>) in.readObject();
        in.close();
    }
}
