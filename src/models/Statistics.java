package models;

import interfaces.IStatistic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Statistics implements IStatistic {
    String path;
    int countOfPas = 0;
    int countPassengersOfFirstClass = 0;
    int countPassengersOfSecondClass = 0;
    int countPassengersOfThirdClass = 0;
    int countOfSurvivedPass = 0;
    int countOfNonSurvivedPass = 0;

    int survivedMen = 0;
    int survivedWomen = 0;
    int survivedChildren = 0;
    int nonSurvivedMen = 0;
    int nonSurvivedWomen = 0;
    int nonSurvivedChildren = 0;

    double totalFares = 0.0;
    double averageFaresFirstClass = 0.0;
    double averageFaresSecondClass = 0.0;
    double averageFaresThirdClass = 0.0;


    public Statistics(String path) {
        this.path = path;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str = br.readLine();
            String[] cells = str.split(",");
            str = br.readLine();
            while (str != null) {
                countOfPas += 1;
                cells = str.split(",");

                double age = (!cells[6].isEmpty()) ? Double.parseDouble(cells[6]) : 18;

                if (cells[1].equals("1")) {
                    countOfSurvivedPass += 1;
                    if (cells[1].equals("1") && cells[5].equals("male") && age >= 18) {
                        survivedMen += 1;
                    }
                    if (cells[1].equals("1") && cells[5].equals("female") && age >= 18) {
                        survivedWomen += 1;
                    }
                    if (cells[1].equals("1") && age < 18) {
                        survivedChildren += 1;
                    }
                }
                if (cells[1].equals("0")) {
                    countOfNonSurvivedPass += 1;
                    if (cells[1].equals("0") && cells[5].equals("male") && age >= 18) {
                        nonSurvivedMen += 1;
                    }
                    if (cells[1].equals("0") && cells[5].equals("female") && age >= 18) {
                        nonSurvivedWomen += 1;
                    }
                    if (cells[1].equals("0") && age < 18) {
                        nonSurvivedChildren += 1;
                    }
                }
                if (cells[2].equals("1")) {
                    countPassengersOfFirstClass += 1;
                    this.averageFaresFirstClass += Double.parseDouble(cells[10]);
                }
                if (cells[2].equals("2")) {
                    countPassengersOfSecondClass += 1;
                    this.averageFaresSecondClass += Double.parseDouble(cells[10]);
                }
                if (cells[2].equals("3")) {
                    countPassengersOfThirdClass += 1;
                    this.averageFaresThirdClass += Double.parseDouble(cells[10]);
                }
                this.totalFares += Double.parseDouble(cells[10]);
                str = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getTotalFares() {
        return totalFares;
    }

    public int countAllPass() {
        return countOfPas;
    }

    @Override
    public double getAverageFaresForClasses(int classOfTravel) {
        if (classOfTravel == 1) {
            return this.averageFaresFirstClass / countPassengersOfFirstClass;
        }
        if (classOfTravel == 2) {
            return this.averageFaresSecondClass / countPassengersOfSecondClass;
        }
        if (classOfTravel == 3) {
            return this.averageFaresThirdClass / countPassengersOfThirdClass;
        } else {
            return 0;
        }
    }

    @Override
    public int getCountOfSurvives(boolean survived) {
        return (survived) ? countOfSurvivedPass : countOfNonSurvivedPass;
    }

    @Override
    public int getCountOfSurvives(boolean survived, String sex) {

        return (survived && sex.equals("male")) ? survivedMen
                : (survived && sex.equals("female")) ? survivedWomen
                : (survived && sex.equals("children") ? survivedChildren
                : (!survived && sex.equals("male")) ? nonSurvivedMen
                : (!survived && sex.equals("female")) ? nonSurvivedWomen
                : (!survived && sex.equals("children")) ? nonSurvivedChildren : 0);
    }
}
