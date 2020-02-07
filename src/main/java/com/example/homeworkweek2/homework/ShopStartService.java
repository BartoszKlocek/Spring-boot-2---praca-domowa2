package com.example.homeworkweek2.homework;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("Start")
public class ShopStartService implements ShopStart {

    protected final List<Product> shoppingList;
    protected double summaryPrice;

    public ShopStartService() {
        shoppingList = new ArrayList<>();
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        Product product3 = new Product("product3");
        Product product4 = new Product("product4");
        Product product5 = new Product("product5");
        shoppingList.add(product1);
        shoppingList.add(product2);
        shoppingList.add(product3);
        shoppingList.add(product4);
        shoppingList.add(product5);

    }

    @Override
    public void addProductToShoppingList(Product product) {
        shoppingList.add(product);

    }

    @Override
    public List<Product> getProductsPrice() {

        return shoppingList;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void showProductsPrice() {

        shoppingList.forEach(a -> System.out.println(a.getName() + ": " + a.getPrice() + " PLN"));
    }

    @Override
    public Double getSummaryPriceNetto() {
        this.summaryPrice = shoppingList.stream()
                .mapToInt(a -> (int) a.getPrice()).sum();

        return summaryPrice;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showSummaryPriceNetto() {
        System.out.println("\nTotal price (NETTO): " + Math.round(getSummaryPriceNetto()*100.0)/100.0 + " PLN");
    }
}
