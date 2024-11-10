package Order;

import Restaurant.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Map;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {
    private String orderId;
    private String customerId;
    private String restaurantId;
    private Map<String,Integer> foodItemList;
    private double totalAmount;
    private OrderStatus orderStatus;

}
