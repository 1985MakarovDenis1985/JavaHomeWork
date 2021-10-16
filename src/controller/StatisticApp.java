package controller;

import models.Statistics;

public class StatisticApp {
    public static void main(String[] args) {
        Statistics titanicStatistic = new Statistics("train.csv");
        double fare = titanicStatistic.getTotalFares();
        int count = titanicStatistic.countAllPass();
        double averPriceFirstClass = titanicStatistic.getAverageFaresForClasses(1);
        double averPriceSecondClass = titanicStatistic.getAverageFaresForClasses(2);
        double averPriceThirdClass = titanicStatistic.getAverageFaresForClasses(3);
        int countOfSurvive = titanicStatistic.getCountOfSurvives(true);
        int countOfNonSurvive = titanicStatistic.getCountOfSurvives(false);

        int survMen = titanicStatistic.getCountOfSurvives(true, "male");
        int survWomen = titanicStatistic.getCountOfSurvives(true, "female"); ;
        int survChildren = titanicStatistic.getCountOfSurvives(true, "children");;
        int NonSurvMen = titanicStatistic.getCountOfSurvives(false, "male");;
        int NonSurvWomen = titanicStatistic.getCountOfSurvives(false, "female");;
        int NonSurvChildren = titanicStatistic.getCountOfSurvives(false, "children");;


        System.out.println("Sum of Price : " + fare);
        System.out.println("Count passengers : " + count);
        System.out.println("Average price of 1 class : " + averPriceFirstClass);
        System.out.println("Average price of 2 class : " + averPriceSecondClass);
        System.out.println("Average price of 3 class : " + averPriceThirdClass);

        System.out.println("Survived : " + countOfSurvive);
        System.out.println("Non survived : " + countOfNonSurvive);
        System.out.println("Survive men : " + survMen);
        System.out.println("NonSurvive men : " + NonSurvMen);
        System.out.println("Survive women : " + survWomen);
        System.out.println("NonSurvive women : " + NonSurvWomen);
        System.out.println("Survive children : " + survChildren);
        System.out.println("NonSurvive children : " + NonSurvChildren);

    }
}
