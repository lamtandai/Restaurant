/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import connect.CategoryDao;
import connect.DishDao;
import connect.OriginDao;
import connect.IngredientDao;
import connect.Ingredient_detailDao;

import Model.Category;
import Model.Dish;
import Model.Ingredient;
import Model.Ingredient_detail;
import Model.Origin;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Manage_service {
    private CategoryDao CategoryDao;
    private DishDao DishDao;
    private IngredientDao IngredientDao ;
    private Ingredient_detailDao Ingredient_detailDao ;
    private OriginDao OriginDao;
    
    public Manage_service(){
        CategoryDao = new CategoryDao ();
        DishDao = new DishDao();
        IngredientDao = new IngredientDao();
        Ingredient_detailDao = new Ingredient_detailDao();
        OriginDao = new OriginDao();
    }
    
    public List <Category> getCategoryList(){
        return CategoryDao.getAllCategory();
    }
    
    public List <Origin> getOriginList(){
        return OriginDao.getAllOrigin();
    }
    
    public List<Dish> getAllDish(){
        return DishDao.getAllDish();
    }
    
    public List <Ingredient> getAllIngre(){
        return IngredientDao.getAllIngredient();
    }
    
    public List <Ingredient_detail> getALlingre_detail(){
        return Ingredient_detailDao.getAllIngredient_detail();
    }
    
    public Dish getDishByID(short ID){
        return DishDao.getDishByID(ID);
    }
    
    public List <Category> getCategoryByDishID(short id){
        return CategoryDao.getCategoryByDishId(id);
    }
    
    public List<Origin> getOriginByDishId(short id){
        return OriginDao.getOriginByDishId(id);
    }
    
}
