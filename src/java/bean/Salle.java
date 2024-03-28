/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author ANDRIANANTENAINA
 */
public class Salle {
    private int codesal;
    private String designation;
    
    public Salle(){}
    
    public Salle(int codesal, String designation){
        super();
        this.codesal = codesal;
        this.designation = designation;
    }
    
    public int getCodesal(){
        return codesal; 
    }
    public void setCodesal(int codesal){
        this.codesal = codesal;
    }
    public String getDesignation(){
        return designation; 
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    @Override
    public String toString(){
        return "Salle [codesal="+codesal+", designation="+designation+"]";
    }
}
