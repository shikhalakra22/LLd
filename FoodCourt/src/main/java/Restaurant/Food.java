package Restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import Restaurant.Category;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {
    private String restaurantId;
    private String name;
    private double price;
    private int quantity;
    private Category category;
    private String cuisineType;
    private int preparationTime;
    private boolean isAvailable;
    private double rating;
    private String description;
    private String imageUrl;


    public Food(String id, String name, double price, int quantity, Category category) {
        this.restaurantId=id;
        this.name = name;
        this.price=price;
        this.quantity = quantity;
        this.category=category;
    }
}
