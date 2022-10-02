package com.company.foodorderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String drink_name;
    private Double price;


    public Drink(String drink_name, Double price) {
        this.drink_name = drink_name;
        this.price = price;
    }


}
