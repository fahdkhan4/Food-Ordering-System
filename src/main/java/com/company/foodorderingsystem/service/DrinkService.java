package com.company.foodorderingsystem.service;

import com.company.foodorderingsystem.model.Drink;
import com.company.foodorderingsystem.dao.DrinkDao;

import java.util.List;
import java.util.Optional;

public class DrinkService {

    private DrinkDao drinkDao = new DrinkDao();

    /**
     *
     * @param drink
     */
    public void add_Drink(Drink drink){
        try{
            drinkDao.savedrink(drink);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Drink> getAllDrinks(){
        return drinkDao.getAllDrinksDao();
    }

    /**
     * Show Drinks
     */
    public void showDrinks(){
        try{
            List<Drink> drinkList =  getAllDrinks();
            if(!drinkList.isEmpty()){
                for (Drink drink:drinkList) {
                    System.out.println(drink.getId()+" )  "+drink.getDrink_name()+"      "+drink.getPrice());
                }
            }
            else{
                System.out.println("Sorry No Drinks Available");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param foodItem
     * @return
     */
    public Drink getDrinkById(Long foodItem) {
        Optional<Drink> drink = null;
        try {
            drink = Optional.ofNullable(drinkDao.getDrinkById(foodItem));
            if(drink.isPresent()){
                return drink.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
