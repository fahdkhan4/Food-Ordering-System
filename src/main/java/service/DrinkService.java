package service;

import Model.Cuisine;
import Model.Cuisines_type;
import Model.Drink;
import Model.Meal;
import dao.DrinkDao;
import dao.MealDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
