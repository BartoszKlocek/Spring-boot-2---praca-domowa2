package com.example.homeworkweek2.homework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("Pro")
public class ShopProService extends ShopPlusService implements ShopPro {
    @Value("${product-info.discount}")
    double discount;

    @Override
    public Double countDiscount() {
        return getSummaryPriceBrutto()-getSummaryPriceBruttoWithDiscount();
    }

    @Override
    public Double getSummaryPriceBruttoWithDiscount() {
        return getSummaryPriceBrutto()-getSummaryPriceBrutto()*discount;
    }

    @Override
    public Double getTaxValueAfterDiscount() {
        return getSummaryPriceBruttoWithDiscount()*getTaxRate();
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showSummaryPriceBruttoWithDiscount() {
        System.out.println("Total price (BRUTTO) with discount: "+getSummaryPriceBruttoWithDiscount());
    }


}
