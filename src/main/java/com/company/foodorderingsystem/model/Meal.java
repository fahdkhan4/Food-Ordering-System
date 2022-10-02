package com.company.foodorderingsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Setter
@NoArgsConstructor


@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meal_name;
    private Double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "meal_cuisine",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "cuisines_id")}
    )

    private List<Cuisine> cuisine_type;

    public Meal(String meal_name, Double price, List<Cuisine> cuisine_type) {
        this.meal_name = meal_name;
        this.price = price;
        this.cuisine_type = cuisine_type;
    }
}
