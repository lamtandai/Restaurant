/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;

public class Dish {
    private short ID;
    private String Name;
    private boolean Availability;
    private float Price;
    private List <Category> CateList;
    private List <Origin> OriList;
    
    public void setID(short ID){
        this.ID = ID;
    }
    public void setN(String N){
        this.Name = N;
    }
    public void setAvailability(boolean A){
        this.Availability = A;
    }
    public void setPrice(float P){
        this.Price = P;
    }
    
    public void setCateList(List <Category> cate){
        CateList = cate;
    }
    public List <Category> getCateList(){
        return CateList;
    }
    
    public void setOriList(List <Origin> ori){
        OriList = ori;
    }
    public List <Origin> getOriList(){
        return OriList;
    }
    public short getID(){
        return ID;
    }
    
    public String getN(){
        return Name;
    }
    
    public boolean getA(){
        return Availability;
    }
    
    public float getPrice(){
        return Price;
    }
    
}

 


