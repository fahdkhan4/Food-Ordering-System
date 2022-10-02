package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Setter
@NoArgsConstructor

@Entity
@Table(name = "order_transaction")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    private LocalDate order_date;
    private Boolean isLemon;
    private Boolean isIceCubes;

    public Order(Meal meal, Drink drink, LocalDate order_date, Boolean isLemon, Boolean isIceCubes) {
        this.meal = meal;
        this.drink = drink;
        this.order_date = order_date;
        this.isLemon = isLemon;
        this.isIceCubes = isIceCubes;
    }
}
