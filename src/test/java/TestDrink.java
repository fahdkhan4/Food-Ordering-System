import com.company.foodorderingsystem.model.Drink;
import com.company.foodorderingsystem.dao.DrinkDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.company.foodorderingsystem.service.DrinkService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestDrink {

    @Mock
    DrinkDao drinkDao;

    @InjectMocks
    DrinkService drinkService;

    List<Drink> drinks = new ArrayList<>();

    @Before
    public void addDrinksForTesting(){
       drinks.add(new Drink("Coca Cola",100.0));
       drinks.add(new Drink("Pepsi",200.0));
    }

    @Test
    public void testShowDrinks(){
        when(drinkDao.getAllDrinksDao()).thenReturn(drinks);

        Assert.assertEquals(drinkService.getAllDrinks(),drinks);
    }

    @Test
    public void testSaveDrink(){
        Drink drink = new Drink("Pepsi",50.0);
        /**
         *  do Nothing For void(method which don't return anything)  method
         */
        doNothing().when(drinkDao).savedrink(anyObject());
        drinkService.add_Drink(drink);
        verify(drinkDao,times(1)).savedrink(drink);
    }

    @Test
    public void testGetDrinkById(){
        Drink drink = new Drink("Fanta",50.0);

        when(drinkDao.getDrinkById(1l)).thenReturn(drink);

//        Assert.assertEquals(drinkService.getDrinkById(2l),drink);
        Assert.assertEquals(drinkService.getDrinkById(1l),drink);

    }



}
