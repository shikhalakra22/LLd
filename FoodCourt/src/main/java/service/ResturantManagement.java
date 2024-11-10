package service;

import Restaurant.Restaurant;

import java.util.*;
import java.util.stream.Collectors;

import Restaurant.Food;
import Restaurant.Rating;

public class ResturantManagement {
    public Map<String, Restaurant> resturantMap;

    public ResturantManagement() {
        resturantMap = new HashMap<>();
    }

    public Restaurant register_restaurant(String id, String name, List<Integer> pincodes, String address) {
        Restaurant restaurant = Restaurant.builder().id((id)).servicablePincodes(pincodes)
                .address(address).name(name).build();
        resturantMap.put(id, restaurant);
        return restaurant;

    }

    public Restaurant addFood(String id, Food food) {
        if (resturantMap.containsKey(id)) {
            Food newFood = Food.builder()
                    .restaurantId(id)
                    .name(food.getName())
                    .price(food.getPrice())
                    .quantity(food.getQuantity())
                    .category(food.getCategory())
                    .build();
            Restaurant restaurant = resturantMap.get(id);
            List<Food> foodList = restaurant.getFoodList();
            if (foodList == null) {
                foodList = new ArrayList<>();
                restaurant.setFoodList(foodList);
            }
            foodList.add(newFood);

          //  resturantMap.put(id, restaurant);

            return restaurant;
        }

        return null;

    }

    public List<Restaurant> getbyfood(String food) {
        List<Restaurant> restaurantList = new ArrayList<>();
        for (Restaurant restaurant : resturantMap.values()) {
            List<Food> foodList = restaurant.getFoodList();
            if (foodList != null && foodList.stream().anyMatch(x -> x.getName().equalsIgnoreCase(food))) {
                restaurantList.add(restaurant);
            }
        }
        return restaurantList;
    }

    public List<Restaurant> getbypincodes(int code) {
        List<Restaurant> restaurantList = new ArrayList<>();
        for (Restaurant restaurant : resturantMap.values()) {
            List<Integer> pincodes = restaurant.getServicablePincodes();
            if (pincodes != null && pincodes.stream().anyMatch(x -> x.equals(code))) {
                restaurantList.add(restaurant);
            }
        }
        return restaurantList;
    }

    public void update_quantity(String resturantName, String foodname, int qty) {
      resturantMap.values().stream().filter(x -> x.getName().equalsIgnoreCase(resturantName)).forEach(
                restaurant -> {
                    List<Food> foodList = restaurant.getFoodList();
                    foodList.stream().filter(x -> x.getName().equalsIgnoreCase(foodname)).
                            forEach(food -> {
                                        food.setQuantity(qty);

                                    }

                            );
                  //  resturantMap.put(restaurant.getId(), restaurant);

                }
        );

    }
    public void rate_restaurant(String restaurant_name,int rating , String  comment){
        Rating rating1 = Rating.builder().rating(rating).comment(comment).build();
        resturantMap.values().stream().filter(x -> x.getName().equalsIgnoreCase(restaurant_name)).forEach(
                restaurant -> {
                    List<Rating> getRatingList = restaurant.getUserRatings();
                    if(getRatingList == null){
                        getRatingList = new ArrayList<>();
                        restaurant.setUserRatings(getRatingList);

                    }
                    getRatingList.add(rating1);
               //     resturantMap.put(restaurant.getId(), restaurant);

                }


        );
    }
}
//avg = (avg*n + rating )/(n+1)

