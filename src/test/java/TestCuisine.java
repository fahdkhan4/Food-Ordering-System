import Model.Cuisine;
import Model.Cuisines_type;
import dao.CuisineDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.CuisineService;

import java.util.ArrayList;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCuisine {

                                                                                 /**
                                                                                 *  Cuisine Test Cases
                                                                                 */
    /**
     * @InjectMocks will create object of the class
     */
    @InjectMocks
    CuisineService cuisineService;

    @Mock
    CuisineDao cuisineDao;

    ArrayList<Cuisine> cuisineList = new ArrayList<>();

    @Before
    public void addCuisineForTesting(){
        cuisineList.add(new Cuisine(Cuisines_type.Polish));
        cuisineList.add(new Cuisine(Cuisines_type.Mexican));
        cuisineList.add(new Cuisine(Cuisines_type.Italian));
    }

    @Test
    public void testShowCuisine(){
        when(cuisineDao.getCuisine()).thenReturn(cuisineList);
        Assert.assertEquals(cuisineService.getAllCuisine(),cuisineList);
    }

    @Test
    public void testSaveCuisine(){
        Cuisine cuisine = new Cuisine(Cuisines_type.Mexican);
        /**
         *  do Nothing For void(method which don't return anything)  method
         */
        doNothing().when(cuisineDao).saveCuisineDao(anyObject());
        cuisineService.saveCuisine(cuisine);
        verify(cuisineDao,times(1)).saveCuisineDao(cuisine);
    }

    @Test
    public void testGetCuisineById(){
        Cuisine mexican = new Cuisine(Cuisines_type.Mexican);

        when(cuisineDao.getCuisineById(1l)).thenReturn(mexican);

//        Assert.assertEquals(cuisineService.getCuisineById(2l),mexican);
        Assert.assertEquals(cuisineService.getCuisineById(1l),mexican);

    }




}
