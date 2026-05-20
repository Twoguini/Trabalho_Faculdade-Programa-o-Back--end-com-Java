/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model;
import java.io.Serializable;

/**
 *
 * @author Twoguini
 */
public class PessoaFisica extends Pessoa implements Serializable {
    private String cpf;
    private int age;
    
    public PessoaFisica(int id, String name, String cpf, int age) {
        super(id, name);
        this.cpf = cpf;
        this.age = age;
    }
    
    @Override
    public void show() {
        System.out.printf("Pessoa Fisica: %nId: %d %nName: %s%nCpf: %s %nAge: %d%n", getId(), getName(), this.cpf, this.age);
    }
    
    public int getAge() { return this.age; } 
    public void setAge(int newAge) { this.age = newAge; } 
    public String getCpf() { return this.cpf; } 
    public void setCpf(String newCpf) { this.cpf = newCpf; }
}
