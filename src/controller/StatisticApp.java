package controller;

import models.Statistics;

public class StatisticApp {
    public static void main(String[] args) {
        Statistics titanicStatistic = new Statistics("train.csv");
        double fare = titanicStatistic.totalFares();
        int count = titanicStatistic.countAllPass();
        double averPriceFirstClass = titanicStatistic.averageFaresForClasses(1);
        double averPriceSecondClass = titanicStatistic.averageFaresForClasses(2);
        double averPriceThirdClass = titanicStatistic.averageFaresForClasses(3);

        System.out.println("Sum of Price : " + fare);
        System.out.println("Count passengers : " + count);
        System.out.println("Average price of 1 class : " + averPriceFirstClass);
        System.out.println("Average price of 2 class : " + averPriceSecondClass);
        System.out.println("Average price of 3 class : " + averPriceThirdClass);
    }
}
