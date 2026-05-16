/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;
import cadastropoo.model.*;

/**
 *
 * @author Twoguini
 */

public class CadastroPOO {
    public static void main(String[] args) {
        try {
            // Pessoa Física
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            repo1.insert(new PessoaFisica(1, "João", "111", 20));
            repo1.insert(new PessoaFisica(2, "Maria", "222", 25));

            repo1.keep("pf.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.retrive("pf.dat");

            for (PessoaFisica p : repo2.getAll()) {
                p.show();
            }

            // Pessoa Jurídica
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            repo3.insert(new PessoaJuridica(1, "Empresa A", "123"));
            repo3.insert(new PessoaJuridica(2, "Empresa B", "456"));

            repo3.keep("pj.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.retrive("pj.dat");

            for (PessoaJuridica p : repo4.getAll()) {
                p.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
