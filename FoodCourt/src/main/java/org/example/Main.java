package org.example;

import Order.Order;
import Restaurant.Restaurant;
import service.OrderService;
import service.ResturantManagement;

import java.util.*;

import Restaurant.Food;
import Restaurant.Category;
import service.SearchService;
import Customer.Customer;

public class Main {

    public static void main(String[] args) {
        Map<String, Restaurant> resturantMainMap = new HashMap<>();
        ResturantManagement resturantManagement = new ResturantManagement();
        OrderService orderService = new OrderService();
        SearchService searchService = new SearchService(resturantManagement);
        List<Integer> servicablepincodes = new ArrayList<>();
        servicablepincodes.add(560035);
        servicablepincodes.add(560032);
        servicablepincodes.add(560037);

        List<Integer> servicablepincodes2 = new ArrayList<>();
        servicablepincodes2.add(560011);
        servicablepincodes2.add(560032);
        servicablepincodes2.add(560035);

        Restaurant restaurant = resturantManagement.register_restaurant("1234","KFC",servicablepincodes,"Sarjapur road");
        Restaurant restaurant2 = resturantManagement.register_restaurant("1111","Dominos",servicablepincodes2,"Sarjapur road");

        Food food = new Food("1234","chicken wings",300.23,20, Category.NONVEGETARIAN);
        Food food2 = new Food("1234","Pizza",274,200, Category.NONVEGETARIAN);
        Food food3 = new Food("1111","Pizza",274,200, Category.VEGETARIAN);

        restaurant = resturantManagement.addFood(restaurant.getId(), food);
        restaurant = resturantManagement.addFood(restaurant.getId(), food2);

        restaurant2 = resturantManagement.addFood(restaurant2.getId(),food3);
        resturantMainMap.put(restaurant.getId(),restaurant);
        resturantMainMap.put(restaurant2.getId(),restaurant2);

        System.out.println(restaurant);
        System.out.println(restaurant2);
        List<Restaurant> getres = searchService.getListofResturant("Pizza");
        System.out.println("Get restaurant by food");
        for (Restaurant res:
             getres) {
            System.out.println(res);

        }


        List<Restaurant> getPincode = resturantManagement.getbypincodes(560011);
        System.out.println("Get restaurant by pincodes");
        for (Restaurant res:
                getPincode) {
            System.out.println(res);

        }

        resturantManagement.update_quantity("KFC","Pizza",100);

        Customer customer = new Customer("Cus_123", "Shikha Lakra", "7999931710", "Sarjapur");

        Map<String, Integer> foodItemList = new HashMap<>();
        foodItemList.put("pizza", 2);


        Order order = orderService.placeOrder(customer.getCustomerId(), "1234",foodItemList,resturantMainMap);
        System.out.println("Order is placed:"+ order.getOrderId());

        resturantManagement.rate_restaurant("KFC", 4,"good food");






    }
}