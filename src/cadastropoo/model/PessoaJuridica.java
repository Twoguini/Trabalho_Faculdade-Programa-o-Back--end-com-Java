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
public class PessoaJuridica extends Pessoa implements Serializable {
    private String CNPJ;
    
    public PessoaJuridica(int id, String name, String CNPJ) {
        super(id, name);
        this.CNPJ = CNPJ;
    }
    
    @Override
    public void show() {
        System.out.printf("Pessoa Juridica: %nId: %d - Name: %s%nCNPJ: %s", getId(), getName(), this.CNPJ);
    }
    
    public String getCNPJ() { return this.CNPJ; } 
    public void setCNPJ(String newCNPJ) { this.CNPJ = newCNPJ; }
}
