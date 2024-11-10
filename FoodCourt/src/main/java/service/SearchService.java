package service;

import Restaurant.Restaurant;

import java.util.List;

public class SearchService {

    ResturantManagement resturantManagement;
    public SearchService(ResturantManagement resturantManagement){
        this.resturantManagement= resturantManagement;
    }

    public List<Restaurant> getListofResturant(String food){
        return resturantManagement.getbyfood(food);
    }
    public List<Restaurant> getListofResturantbyCodes(int code){
        return resturantManagement.getbypincodes(code);
    }
}
