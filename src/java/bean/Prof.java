/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author ANDRIANANTENAINA
 */
public class Prof {
    private int codeprof;
    private String nom;
    private String prenom;
    private String grade;
    
    public Prof(){}
    
    public Prof(int codeprof, String nom, String prenom, String grade){
        super();
        this.codeprof = codeprof;
        this.grade = grade;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public int getCodeprof(){
        return codeprof; 
    }
    public void setCodeprof(int codeprof){
        this.codeprof = codeprof;
    }
    public String getNom(){
        return nom; 
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    @Override
    public String toString(){
        return "Prof [codeprof="+codeprof+", nom="+nom+", prenom="+prenom+", grade="+grade+"]";
    }
}
