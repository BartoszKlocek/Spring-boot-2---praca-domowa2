package com.example.homeworkweek2.homework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("Plus")
public class ShopPlusService extends ShopStartService implements ShopPlus {

    @Value("${product-info.tax}")
    double taxRate;

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public Double getSummaryPriceBrutto() {

        return getSummaryPriceNetto()+ getSummaryPriceNetto()* taxRate;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showSummaryPriceBrutto() {
        System.out.println("Total price (BRUTTO): "+ getSummaryPriceBrutto());
    }

    @Override
    public Double getTaxValue() {
        return getSummaryPriceBrutto()-getSummaryPriceNetto();
    }
@EventListener(ApplicationReadyEvent.class)
    public void showTaxValue() {
        System.out.println("Tax value: "+Math.round((getSummaryPriceBrutto()-getSummaryPriceNetto())*100.0)/100.0);
    }
}
