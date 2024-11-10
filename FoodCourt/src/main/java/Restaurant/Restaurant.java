package Restaurant;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private String id;
    private String name;
    private List<Integer> servicablePincodes;
    private List<Food> foodList;
    private String address;
    private List<Rating> userRatings;
    private double avgRating;

}
