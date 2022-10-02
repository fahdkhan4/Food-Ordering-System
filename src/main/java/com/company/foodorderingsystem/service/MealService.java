package com.company.foodorderingsystem.service;

import com.company.foodorderingsystem.model.Cuisine;
import com.company.foodorderingsystem.model.Meal;
import com.company.foodorderingsystem.dao.MealDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MealService {

    private MealDao mealDao = new MealDao();

    /**
     *
     * @param meal
     */
    public void add_Meal(Meal meal){
        try{
            mealDao.saveMeal(meal);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public List<Meal> getAllMeals(){
        List<Meal> meals = new ArrayList<>();
        try{
            meals = mealDao.showMeals();
        }catch (Exception e){
            e.printStackTrace();
        }
        return meals;
    }

    /**
     *
     * @param cuisine
     * @return
     */
    public List<Meal> getMealsByCuisineType(Cuisine cuisine){
        return mealDao.getMealByCuisineTypeDao(cuisine);
    }

    /**
     *
     * @param cuisines
     */
    public void showMeals(Cuisine cuisines){

            try {
                List<Meal> mealList = getMealsByCuisineType(cuisines);
                if (!mealList.isEmpty()) {
                    for (Meal meal:mealList) {
                        System.out.println("        " + meal.getId() + " )   " + meal.getMeal_name() + "      " + meal.getPrice() + "      ");
                    }
                } else {
                    System.out.println("Sorry No Meals Available with Cuisine "+cuisines.getCuisine_name());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    /**
     *
     * @param id
     * @return
     */
    public Meal getMealById(Long id){
        Optional<Meal> meal = null;
        try {
            meal = Optional.ofNullable(mealDao.getMealById(id));
            if(meal.isPresent()){
                return meal.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Meal getMealsByIdAndCuisineType(Long id,Long cuisineType){
        Optional<Meal> meal = null;
        try {
            meal = Optional.ofNullable(mealDao.getMealByIdAndCuisineType(id,cuisineType));
            if(meal.isPresent()){
                return meal.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
