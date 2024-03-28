/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author ANDRIANANTENAINA
 */
public class Occuper {
    private int codeocc;
    private int codesal;
    private String datee;
    private int h1;
    private int h2;
    private int h3;
    private int h4;
    private int h5;
    private int h6;
    
    public Occuper(){}
    public Occuper(int codeocc, int codesal, String datee, int h1,int h2,int h3,int h4,int h5,int h6){
        super();
        this.codeocc = codeocc;
        this.codesal = codesal;
        this.datee = datee;
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.h4 = h4;
        this.h5 = h5;
        this.h6 = h6;
    }
    
    public int getCodeocc(){
        return codeocc;
    }
    public void setCodeocc(int codeocc){
        this.codeocc = codeocc;
    }

    
    public int getH1(){
        return h1; 
    }
    public void setH1 (int h1){
        this.h1 = h1;
    }
    public int getH2(){
        return h2; 
    }
    public void setH2 (int h2){
        this.h2 = h2;
    }
    public int getH3(){
        return h3; 
    }
    public void setH3 (int h3){
        this.h3 = h3;
    }
    public int getH4(){
        return h4; 
    }
    public void setH4 (int h4){
        this.h4 = h4;
    }
    public int getH5(){
        return h5; 
    }
    public void setH5 (int h5){
        this.h5 = h5;
    }
    public int getH6(){
        return h6; 
    }
    public void setH6 (int h6){
        this.h6 = h6;
    }


    public int getCodesal(){
        return codesal; 
    }
    public void setCodesal(int codesal){
        this.codesal = codesal;
    }
    public void setDatee(String datee){
        this.datee = datee;
    }
    public String getDatee(){
        return datee;
    }
    @Override
    public String toString(){
        return "Prof [codesal="+codesal+", datee="+datee+", h1="+h1+", h2="+h2+", h3="+h3+", h4="+h4+", h5="+h5+", h6="+h6+"]";
    }
}
