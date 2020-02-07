package com.example.homeworkweek2.homework;

import org.springframework.beans.factory.annotation.Autowired;
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

    protected RandomPrice randomPrice;


    public ShopStartService() {
        shoppingList = new ArrayList<>();
        Product product1 = new Product("Wafelek", new RandomPrice().getRandomPrice());
        Product product2 = new Product("Czekolada mleczna 100gr", new RandomPrice().getRandomPrice());
        Product product3 = new Product("Papier toaletowy", new RandomPrice().getRandomPrice());
        Product product4 = new Product("Szynka 100gr.", new RandomPrice().getRandomPrice());
        Product product5 = new Product("Coca-cola puszka", new RandomPrice().getRandomPrice());
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
    public double getSummaryPrice() {
        Integer sum = shoppingList.stream()
                .mapToInt(a -> (int) a.getPrice()).sum();

        return sum;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showSummaryPrice() {
        System.out.println("\nTotal price: " + getSummaryPrice() + " PLN");
    }
}
