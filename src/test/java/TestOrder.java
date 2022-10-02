import com.company.foodorderingsystem.model.*;
import com.company.foodorderingsystem.dao.OrderDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.company.foodorderingsystem.service.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestOrder {

    @InjectMocks
    OrderService orderService;


    @Mock
    OrderDao orderDao;


    @Test
    public void testSaveOrder(){
        Meal meal = new Meal("Pasta",30.0,new ArrayList<>(Arrays.asList(new Cuisine(Cuisines_type.Mexican))));
        Drink drink = new Drink("Coca Cola",50.0);

        Order order = new Order(meal,drink, LocalDate.now(),false,true);

        /**
         * If the order get saved return its order id
         */
        when(orderDao.saveOrder(order)).thenReturn(1l);
        Assert.assertEquals(orderDao.saveOrder(order),(Long) 1l);

    }

    @Test
    public void testGetOrderById(){
        Meal meal = new Meal("Pasta",30.0,new ArrayList<>(Arrays.asList(new Cuisine(Cuisines_type.Mexican))));
        Drink drink = new Drink("Coca Cola",50.0);

        Order order = new Order(meal,null, LocalDate.now(),false,false);

       Mockito.when(orderDao.getOrderById(1l)).thenReturn(order);
//                                                                          Test Case will Fail
//       Assert.assertEquals(orderDao.getOrderById(2l),order);
//                                                                          Test Case Will Pass
       Assert.assertEquals(orderDao.getOrderById(1l),order);

    }





}
