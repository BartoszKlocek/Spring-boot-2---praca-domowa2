package com.example.homeworkweek2.homework;

import java.util.List;

public interface ShopStart {
    public void addProductToShoppingList(Product product);
    public List<Product> getProductsPrice();
    public void showProductsPrice();
    public Double getSummaryPriceNetto();
    public void showSummaryPriceNetto();
}
