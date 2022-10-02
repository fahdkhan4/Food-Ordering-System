import com.company.foodorderingsystem.model.Cuisine;
import com.company.foodorderingsystem.model.Cuisines_type;
import com.company.foodorderingsystem.model.Meal;
import com.company.foodorderingsystem.dao.MealDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.company.foodorderingsystem.service.MealService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMeal {

    /**
     * @InjectMocks will create object of the class
     */
    @InjectMocks
    private MealService mealService;

    @Mock
    private  MealDao mealDao;

    List<Meal> mealList = new ArrayList<>();

    @Before
    public void addMealsForTesting(){
        mealList.add(new Meal("Pasta",20.0,new ArrayList<>(Arrays.asList(new Cuisine(Cuisines_type.Mexican)))));
        mealList.add(new Meal("Macroni",100.0,new ArrayList<>(Arrays.asList(new Cuisine(Cuisines_type.Mexican)))));
    }

                                                                                        /**
                                                                                         *  Test Cases For Meal
                                                                                         */
    @Test
    public void testGetMealsByCuisineType(){
        /**
         * Add Meals in List For Testing
         */

        when(mealDao.getMealByCuisineTypeDao(new Cuisine(Cuisines_type.Mexican))).thenReturn(mealList);

        Assert.assertEquals(mealService.getMealsByCuisineType(new Cuisine(Cuisines_type.Mexican)).size(),2);
//        Assert.assertEquals(mealService.getMealsByCuisineType(new Cuisine(Cuisines_type.Polish)).size(),0);
//        Assert.assertEquals(mealService.getMealsByCuisineType(new Cuisine(Cuisines_type.Italian)).size(),0);
    }

    @Test
    public void testGetAllMeals(){
        /**
         * Add Meals in List For Testing
         */

//        when(mealDao.showMeals()).thenReturn(null);
        when(mealDao.showMeals()).thenReturn(mealList);

//        Assert.assertEquals(mealService.getAllMeals(),null);
        Assert.assertEquals(mealService.getAllMeals(),mealList);
    }

    @Test
    public void testGetMealById(){
        Meal meal = new  Meal("Macroni",100.0,new ArrayList<>(Arrays.asList(new Cuisine(Cuisines_type.Mexican))));
        when(mealDao.getMealById(1l)).thenReturn(meal);

        Assert.assertEquals(mealService.getMealById(1l),meal);

    }

    @Test
    public void testSaveMeal(){
        List<Meal> meals = new ArrayList<>();
        Meal meal = new  Meal("Macroni",200.0,new ArrayList<>(Arrays.asList(new Cuisine(Cuisines_type.Italian))));

        /**
         *  do Nothing For void(method which don't return anything)  method
         */
        doNothing().when(mealDao).saveMeal(anyObject());
        mealService.add_Meal(meal);
        verify(mealDao,times(1)).saveMeal(meal);
    }

    @Test
    public void testGetMealByIdAndCuisineId(){
        Meal meal = new  Meal("Macroni",200.0,new ArrayList<>(Arrays.asList(new Cuisine(Cuisines_type.Italian))));

        when(mealDao.getMealByIdAndCuisineType(1l,1l)).thenReturn(meal);

        Assert.assertEquals(mealService.getMealsByIdAndCuisineType(1l,1l),meal);
//        Assert.assertEquals(mealService.getMealsByIdAndCuisineType(2l,1l),meal);

    }




}
