package service;

import Order.OrderStatus;
import Restaurant.Food;
import Order.Order;
import Restaurant.Restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderService {
    List<Order> orderList = new ArrayList<>();


    public Order placeOrder(String customerId, String restaurantId, Map<String, Integer> foodItemList, Map<String, Restaurant> restaurantMap) {
        Restaurant restaurant = restaurantMap.get(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return null;
        }
        double totalAmount = 0;
        for (Map.Entry<String, Integer> entry : foodItemList.entrySet()) {
            String foodName = entry.getKey();
            int requestedQuantity = entry.getValue();


            Optional<Food> foodOpt = restaurant.getFoodList().stream()
                    .filter(food -> food.getName().equalsIgnoreCase(foodName) && food.getQuantity() >= requestedQuantity)
                    .findFirst();

            if (!foodOpt.isPresent()) {
                System.out.println("Item " + foodName + " is either unavailable or insufficient in quantity.");
                return null;
            }

            Food food = foodOpt.get();
            totalAmount += food.getPrice() * requestedQuantity;
            food.setQuantity(food.getQuantity() - requestedQuantity);
        }

        Order order = Order.builder()
                .orderId(generateOrderId())
                .customerId(customerId)
                .restaurantId(restaurantId)
                .foodItemList(foodItemList)
                .totalAmount(totalAmount)
                .orderStatus(OrderStatus.PLACED)
                .build();

        System.out.println("Order placed successfully!");
        orderList.add(order);
        return order;
    }

    private String generateOrderId() {
        return "ORD" + System.currentTimeMillis();
    }
    public List<Order> getOrderList(){
        return orderList;
    }


}
