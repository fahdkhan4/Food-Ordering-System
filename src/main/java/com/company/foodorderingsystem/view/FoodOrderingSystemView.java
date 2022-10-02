package com.company.foodorderingsystem.view;

import com.company.foodorderingsystem.model.Cuisine;
import com.company.foodorderingsystem.service.CuisineService;
import com.company.foodorderingsystem.service.DrinkService;
import com.company.foodorderingsystem.service.MealService;
import com.company.foodorderingsystem.service.OrderService;

import java.util.Optional;
import java.util.Scanner;

public class FoodOrderingSystemView {

    private CuisineService cuisineService = new CuisineService();
    private MealService mealService = new MealService();
    private DrinkService drinkService = new DrinkService();
    private OrderService orderService = new OrderService();

    public  void orderingSystemView(){
        Boolean wantLemon = false;
        Boolean wantIceCubes = false;
        Integer chooseOptions = null;
        Long selectCuisine = null;
        Long selectFoodItem  = null;

        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("                                              Welcome To Food Ordering System                                             ");
            System.out.println("What Would you like to have ?");
            System.out.println("1 ) Meal ");
            System.out.println("2 ) Drink ");
            System.out.println("");
            System.out.print("Select category : ");

            /**
             * Choose Options From Given
             */
            try {
                /**
                 *  Handle if the user give the input in different data type ( string ,char)
                 */
                 chooseOptions = userInput.nextInt();
            }catch (Exception e){
                System.out.println("                    Invalid Option Chosen                 ");
                orderingSystemView();
            }

            switch (chooseOptions) {
                case 1:

                    /**
                     *  if the choosing option is 1 ( Meal ) show cuisine
                     */

                    System.out.println("Select Cuisine For your Meal : ");
                    cuisineService.showCuisine();
                    System.out.println("");
                    System.out.print("Selected Cuisine : ");

                    /**
                     *  Select Cuisine From the given options
                     */
                    try{
                        /**
                         *  Handle if the user give the input in different data type ( string ,char)
                         */
                        selectCuisine = userInput.nextLong();
                    }
                    catch (Exception e){
                        System.out.println("                    Invalid Cuisine type Chosen                 ");
                        orderingSystemView();
                    }

                    Optional<Cuisine> selectedCuisine = Optional.ofNullable(cuisineService.getCuisineById(selectCuisine));
                    if(!selectedCuisine.isPresent()){
                        /**
                         * If the user selected an Invalid Cuisine re run the application
                         */
                        orderingSystemView();
                    }

                    /**
                     * Select Meal From the Options
                     */
                    System.out.println("Select Food Item From List Of "+selectedCuisine.get().getCuisine_name()+" : ");

                    /**
                     * Show All Meals with selected  `Cuisine`
                     */
                    mealService.showMeals(selectedCuisine.get());
                    break;
                case 2:
                    /**
                     *  if the choosing option is 2 ( Drink )
                     */
                    System.out.println("                                                List Of Drinks                  ");
                    drinkService.showDrinks();
                    break;
                default:
                    /**
                     * If the user selected an Invalid Option re run the application
                     */
                    System.out.println("Invalid Lunch Option");
                    orderingSystemView();
            }

            System.out.print("Select Food Item : ");
            try {
                selectFoodItem = userInput.nextLong();
            }catch (Exception e){
                System.out.println("                    Invalid Food Item Chosen                 ");
                orderingSystemView();
            }

            /**
             *  If User chooses (Drink) then ask about Lemon and Ice Cubes
             */
            switch (chooseOptions){
                case 2:
                    if(drinkService.getDrinkById(selectFoodItem) == null){
                        /**
                         * If the user selected an Invalid Drink id re run the application
                         */
                        System.out.println("                        Invalid Drink Selected ");
                        orderingSystemView();
                    }

                    System.out.print("1 ) Want Lemon ?  Y / N : ");
                    Character lemonWant = Character.toUpperCase(userInput.next().charAt(0));
                    System.out.print("2 ) Want Ice Cubes ? Y / N : ");
                    Character iceCubeWant = Character.toUpperCase(userInput.next().charAt(0));
//                                                                          Cases for lemon
                    switch (lemonWant){
                        case 'Y':
                            wantLemon = true;
                            break;
                        case 'N':
                            wantLemon = false;
                            break;
                        default:
                            /**
                             * If the user selected an Invalid Option re run the application
                             */
                            System.out.println("                        Invalid Selection                   ");
                            orderingSystemView();
                    }
//                                                                          Cases for Ice Cubes
                    switch (iceCubeWant){
                        case 'Y':
                            wantIceCubes = true;
                            break;
                        case 'N':
                            wantIceCubes = false;
                            break;
                        default:
                            /**
                             * If the user selected an Invalid Option re run the application
                             */
                            System.out.println("                        Invalid Selection                           ");
                            orderingSystemView();
                    }

            }
            /**
             *  Now place The Order
             */

            Optional<Long> orderId = Optional.ofNullable(orderService.placeOrder(chooseOptions,selectFoodItem,selectCuisine,wantLemon,wantIceCubes));
            if(!orderId.isPresent()){
                System.out.println(" ");
                System.out.println("Invalid Food Item Id "+selectFoodItem);
                orderingSystemView();
            }

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("                                 Congratulation Your Order Has Been Placed                ");
            System.out.println("                                       Your order Id  is "+orderId.get()+"               ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }
}
