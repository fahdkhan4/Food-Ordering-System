package com.company.foodorderingsystem;

import org.apache.logging.log4j.core.config.Configurator;
import com.company.foodorderingsystem.service.CuisineService;
import com.company.foodorderingsystem.service.DrinkService;
import com.company.foodorderingsystem.service.MealService;
import com.company.foodorderingsystem.view.FoodOrderingSystemView;

public class main {


    static {
        Configurator.setLevel("org.hibernate", org.apache.logging.log4j.Level.OFF);
    }
    public static void main(String[] args) {


        FoodOrderingSystemView foodOrderingSystemView = new FoodOrderingSystemView();
        CuisineService cuisineService = new CuisineService();
        MealService mealService = new MealService();
        DrinkService drinkService = new DrinkService();

        /**
         *  Save Cuisine To Database
         */
//        Cuisine mexican_cuisine = new Cuisine(Cuisines_type.Mexican);
//        Cuisine polish_cuisine = new Cuisine(Cuisines_type.Polish);
//        Cuisine italian_cuisine = new Cuisine(Cuisines_type.Italian);
//
//        cuisineService.saveCuisine(mexican_cuisine);
//        cuisineService.saveCuisine(polish_cuisine);
//        cuisineService.saveCuisine(italian_cuisine);

        /**
         *  Get Cuisine From Database
         */
//        Cuisine mexican = cuisineService.getCuisineById(1l);
//        Cuisine polish = cuisineService.getCuisineById(2l);
//        Cuisine italian = cuisineService.getCuisineById(3l);

        /**
         *  Save Meals To the Database
         */
//        Meal rice = new Meal("Rice",30.0,new ArrayList<>(Arrays.asList(mexican)));
//        Meal pasta = new Meal("Pasta",50.0,new ArrayList<>(Arrays.asList(mexican,italian,polish)));
//        Meal curry = new Meal("Curry",100.0,new ArrayList<>(Arrays.asList(polish)));
//        Meal burrito = new Meal("Burrito",200.0,new ArrayList<>(Arrays.asList(mexican,italian)));
//        Meal pizza = new Meal("Pizza",500.0,new ArrayList<>(Arrays.asList(mexican)));
//        Meal chicken_wing = new Meal("Chicken wing",400.0,new ArrayList<>(Arrays.asList(polish,italian)));
//          Meal molten_lava_cake = new Meal("Molten lava cake",100.0,new ArrayList<>(Arrays.asList(mexican,polish)));
//          Meal ice_cream = new Meal("Ice Cream",150.0,new ArrayList<>(Arrays.asList(polish,italian)));
//          Meal custard = new Meal("Custard",40.0,new ArrayList<>(Arrays.asList(italian,polish,mexican)));



//        mealService.add_Meal(rice);
//        mealService.add_Meal(pasta);
//        mealService.add_Meal(curry);
//        mealService.add_Meal(burrito);
//        mealService.add_Meal(pizza);
//        mealService.add_Meal(chicken_wing);
//        mealService.add_Meal(molten_lava_cake);
//        mealService.add_Meal(ice_cream);
//        mealService.add_Meal(custard);


        /**
         *  Save Drinks To the Database(Record)
         */
//        Drink cola = new Drink("Cola",50.0);
//        Drink sprite = new Drink("Sprite",30.0);
//        Drink juice = new Drink("Juice",100.0);
//        Drink pinaColada = new Drink("Pina Colada",200.0);
//        Drink fanta = new Drink("Fanta",30.0);
//
//        drinkService.add_Drink(cola);
//        drinkService.add_Drink(sprite);
//        drinkService.add_Drink(juice);
//        drinkService.add_Drink(pinaColada);
//        drinkService.add_Drink(fanta);

        /**
         *  Food Ordering System View
         */

        foodOrderingSystemView.orderingSystemView();


    }
}
