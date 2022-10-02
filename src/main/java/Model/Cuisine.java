package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data

@NoArgsConstructor
@Builder
@AllArgsConstructor

@Entity
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Cuisines_type cuisine_name;

    public Cuisine(Cuisines_type cuisine_name) {
        this.cuisine_name = cuisine_name;
    }


}
