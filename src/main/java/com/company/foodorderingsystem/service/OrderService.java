package com.company.foodorderingsystem.service;

import com.company.foodorderingsystem.model.Drink;
import com.company.foodorderingsystem.model.Meal;
import com.company.foodorderingsystem.model.Order;
import com.company.foodorderingsystem.dao.OrderDao;

import java.time.LocalDate;

public class OrderService {

    MealService mealService = new MealService();
    DrinkService drinkService = new DrinkService();
    OrderDao orderDao = new OrderDao();


    /**
     *
     * @param choosenOption
     * @param foodItem
     * @param wantLemon
     * @param wantIceCubes
     * @return
     */
    public Long placeOrder(Integer choosenOption,Long foodItem,Long selectedCuisine,Boolean wantLemon,Boolean wantIceCubes){
        Meal meal = new Meal();
        Drink drink = new Drink();
        Long orderId = null;

        Boolean lemon = wantLemon;
        Boolean wantIceCube = wantIceCubes;

        switch (choosenOption){
            case 1:
                /**
                 * If Choosing Option is Meal
                 */
                meal = mealService.getMealsByIdAndCuisineType(foodItem,selectedCuisine);
                drink = null;
                break;

            case 2:
                /**
                 * If Choosing Option is Drink
                 */
                drink = drinkService.getDrinkById(foodItem);
                meal = null;
                break;

            default:
                System.out.println("Invalid Option");
        }

        try {
            if(meal != null || drink != null){
                Order order = new Order(meal,drink,LocalDate.now(),wantLemon,wantIceCubes);
                orderId = orderDao.saveOrder(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }
}
