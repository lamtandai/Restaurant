/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

// */ID varchar (5),
//    Title varchar (20) not null,
//    Quantity smallint not null,
//    Import_date date not null,
//    Export_date date not null,
//    Unit_title varchar(5) not null,

public class Ingredient {
    private String ID;
    private String Title;
    private String Unit_title;
    
    public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }
    public void setT(String T){
        Title = T;
    }
    
    public void setU(String U){
        Unit_title = U;
    }
    
    public String getT(){
        return Title;
    }
    
    public String getU(){
        return Unit_title;
    }
    
       
    
}
