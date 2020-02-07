package com.example.homeworkweek2.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;


public class RandomPrice {
    private double a;


    public RandomPrice() {

        a =  Math.round((50+ (Math.random()*250))*100.0)/100.0;
    }

    public double getRandomPrice() {
        return a;
    }

    //    public static double getRandomPrice(){
//        return this.a;
//    }

}

