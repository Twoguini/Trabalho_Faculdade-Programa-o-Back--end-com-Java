/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;
import cadastropoo.model.*;
import java.util.Scanner;

/**
 *
 * @author Twoguini
 */

public class CadastroPOO {
    
    public void firstPartActivity() {
        try {
            
            // ========================================
            //                First Part
            // ========================================
            
            // Pessoa Física
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            repo1.insert(new PessoaFisica(1, "Ana", "11111111111", 25));
            repo1.insert(new PessoaFisica(2, "Carlos", "22222222222", 52));
            System.out.printf("Dados de Pessoa Fisica Armazenados%n");

            repo1.keep("pf.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.retrive("pf.dat");

            for (PessoaFisica p : repo2.getAll()) {
                p.show();
            }

            // Pessoa Jurídica
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            repo3.insert(new PessoaJuridica(3, "XPTO Sales", "33333333333"));
            repo3.insert(new PessoaJuridica(4, "XPTO Solutions", "44444444444"));
            System.out.printf("Dados de Pessoa Juridica Armazenados%n");

            repo3.keep("pj.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.retrive("pj.dat");

            for (PessoaJuridica p : repo4.getAll()) {
                p.show();
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        int selectedOption;
        char selectedTypePessoa = ' ';
        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();
        Scanner inptReader = new Scanner(System.in);

        do {
            System.out.printf("Opcoes:%n "
                + "=================================%n"
                + "1 - Incluir%n"
                + "2 - Alterar%n"
                + "3 - Excluir%n"
                + "4 - Exibir p/ Id%n"
                + "5 - Exibir Todos%n"
                + "6 - Salvar%n"
                + "7 - Recuperar Dados%n"
                + "0 - Exit.%n"
                + "=================================%n");

            selectedOption = inptReader.nextInt();
            
            if(selectedOption < 0 || selectedOption > 7) {
                return;
            }

            switch (selectedOption){
                case 6:
                case 7:
                    break;
                case 0:
                    return;
                default:
                    System.out.printf("F - Pessoa Fisica%n"
                            + "J - Pessoa Juridica%n");

                    selectedTypePessoa = inptReader.next().toUpperCase().charAt(0);

                    if(selectedTypePessoa != 'F' && selectedTypePessoa != 'J') {
                        System.out.println("Opcao invalida!");
                        return;
                    }
                    break;
            }

            switch (selectedOption){
                case 1: // Incluir
                    System.out.println("Id:");
                    int id = inptReader.nextInt();
                    System.out.println("Nome:");
                    String nome = inptReader.next();

                    if (selectedTypePessoa == 'F') {
                        System.out.println("CPF:");
                        String cpf = inptReader.next();
                        System.out.println("Idade:");
                        int idade = inptReader.nextInt();

                        repoPF.insert(new PessoaFisica(id, nome, cpf, idade));
                    } else {
                        System.out.println("CNPJ:");
                        String cnpj = inptReader.next();

                        repoPJ.insert(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;

                case 2: // Alterar
                    System.out.println("Id:");
                    int idAlt = inptReader.nextInt();

                    if (selectedTypePessoa == 'F') {
                        PessoaFisica pf = repoPF.get(idAlt);
                        if (pf != null) {
                            pf.show();

                            System.out.println("Novo Nome:");
                            String nomeNovo = inptReader.next();
                            System.out.println("Novo CPF:");
                            String cpf = inptReader.next();
                            System.out.println("Nova Idade:");
                            int idade = inptReader.nextInt();

                            repoPF.alter(new PessoaFisica(idAlt, nomeNovo, cpf, idade));
                        }
                    } else {
                        PessoaJuridica pj = repoPJ.get(idAlt);
                        if (pj != null) {
                            pj.show();

                            System.out.println("Novo Nome:");
                            String nomeNovo = inptReader.next();
                            System.out.println("Novo CNPJ:");
                            String cnpj = inptReader.next();

                            repoPJ.alter(new PessoaJuridica(idAlt, nomeNovo, cnpj));
                        }
                    }
                    break;

                case 3: // Excluir
                    System.out.println("Id:");
                    int idDel = inptReader.nextInt();

                    if (selectedTypePessoa == 'F') {
                        repoPF.delete(idDel);
                    } else {
                        repoPJ.delete(idDel);
                    }
                    break;

                case 4: // Exibir por ID
                    System.out.println("Id:");
                    int idGet = inptReader.nextInt();

                    if (selectedTypePessoa == 'F') {
                        PessoaFisica pf = repoPF.get(idGet);
                        if (pf != null) pf.show();
                    } else {
                        PessoaJuridica pj = repoPJ.get(idGet);
                        if (pj != null) pj.show();
                    }
                    break;

                case 5: // Exibir todos
                    if (selectedTypePessoa == 'F') {
                        for (PessoaFisica p : repoPF.getAll()) {
                            p.show();
                        }
                    } else {
                        for (PessoaJuridica p : repoPJ.getAll()) {
                            p.show();
                        }
                    }
                    break;

                case 6: // Salvar
                    try {
                        System.out.println("Prefixo:");
                        String prefixo = inptReader.next();

                        repoPF.keep(prefixo + ".fisica.bin");
                        repoPJ.keep(prefixo + ".juridica.bin");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar");
                    }
                    break;

                case 7: // Recuperar
                    try {
                        System.out.println("Prefixo:");
                        String prefixo = inptReader.next();

                        repoPF.retrive(prefixo + ".fisica.bin");
                        repoPJ.retrive(prefixo + ".juridica.bin");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar");
                    }
                    break;
            }

        } while(selectedOption != 0);
    }
}
