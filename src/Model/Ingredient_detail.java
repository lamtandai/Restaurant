/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Ingredient_detail {
    
    private String ID;
    private float Quantity;
    private Date Import_date;
    private Date Export_date;
    
     public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }
    public void setQ(float Q){
        Quantity = Q;
    }
    
    public void setI(Date I){
        Import_date = I;
    }
    
    public void setE(Date E){
        Export_date = E;
    } 
    public float getQ(){
        return Quantity;
    }
    
    public Date getI(){
        return Import_date;
    }
    
    public Date getE(){
        return Export_date;
    }
    
}
