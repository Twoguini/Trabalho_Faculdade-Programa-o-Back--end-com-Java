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
public class Pessoa implements Serializable {
    private int id;
    private String name; 
    
    public Pessoa(int lastUsedId, String name) {
        this.id = lastUsedId + 1;
        this.name = name;
    }
    
    public void show() {
        System.out.printf("Id: %d - Name: %s", id, name);
    }
    
    public int getId() { return this.id; } 
    public void setId(int newId) { this.id = newId; } 
    public String getName() { return this.name; } 
    public void setName(String newName) { this.name = newName; } 
}
