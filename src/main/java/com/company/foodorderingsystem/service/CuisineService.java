package com.company.foodorderingsystem.service;

import com.company.foodorderingsystem.model.Cuisine;
import com.company.foodorderingsystem.dao.CuisineDao;
import com.company.foodorderingsystem.exceptions.ContentNotFound;

import java.util.List;
import java.util.Optional;

public class CuisineService {

    private CuisineDao  cuisineDao = new CuisineDao();

    /**
     *
     * @param cuisine
     */
    public void saveCuisine(Cuisine cuisine){
        try{
            cuisineDao.saveCuisineDao(cuisine);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @param id
     * @return
     */
    public Cuisine getCuisineById(Long id){
        Optional<Cuisine> cuisine = null;
        try {
             cuisine = Optional.ofNullable(cuisineDao.getCuisineById(id));
             if(cuisine.isPresent()){
                 return cuisine.get();
             }
            System.out.println("            No Cuisine Found having id "+id         );
        } catch (Exception e) {
            throw new ContentNotFound("No Cuisine Found Having id "+id);
        }
        return null;
    }

    /**
     *  Get All Cuisines
     */
    public List<Cuisine> getAllCuisine(){
        return cuisineDao.getCuisine();
    }

    /**
     * Show Cuisine
     */
    public void showCuisine(){

        try{
            List<Cuisine> cuisines= getAllCuisine();
            for (Cuisine cuisine:cuisines) {
                System.out.println(cuisine.getId()+" ) "+cuisine.getCuisine_name());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
