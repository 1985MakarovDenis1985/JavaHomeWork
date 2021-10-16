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

    double totalFares = 0;
    double averageFaresFirstClass = 0;
    double averageFaresSecondClass = 0;
    double averageFaresThirdClass = 0;

    public double getTotalFares() {
        return totalFares;
    }

    public double getAverageFaresFirstClass() {
        return averageFaresFirstClass;
    }

    public double getAverageFaresSecondClass() {
        return averageFaresSecondClass;
    }

    public double getAverageFaresThirdClass() {
        return averageFaresThirdClass;
    }

    public Statistics(String path) {
        this.path = path;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str = br.readLine();
            String[] cells = str.split(",");
            System.out.println(cells[9]);
            System.out.println("PassengerId 0 | Survived 1 | Pclass 2 | Name 3 | Sex 4 | Age 5 | SibSp 6 | Parch 7 | Ticket 8 | Fare 9 | Cabin 10 | Embarked 11 |");

            str = br.readLine();

            while (str != null) {
                countOfPas += 1;
                cells = str.split(",");
                if (cells[2].equals("1")) {
                    countPassengersOfFirstClass +=1;
                    this.averageFaresFirstClass += Double.parseDouble(cells[10]);
                }
                if (cells[2].equals("2")) {
                    countPassengersOfSecondClass+=1;
                    this.averageFaresSecondClass += Double.parseDouble(cells[10]);
                }
                if (cells[2].equals("3")) {
                    countPassengersOfThirdClass+=1;
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

        System.out.println(averageFaresFirstClass);
    }

    @Override
    public double totalFares() {
        return totalFares;
    }

    public int countAllPass() {
        return countOfPas;
    }

    @Override
    public double averageFaresForClasses(int classOfTravel) {
        if (classOfTravel == 1) {
            return this.averageFaresFirstClass / countPassengersOfFirstClass;
        }
        if (classOfTravel == 2) {
            return this.averageFaresSecondClass / countPassengersOfSecondClass;
        }
        if (classOfTravel == 3) {
            return this.averageFaresThirdClass / countPassengersOfThirdClass;
        }
        else {
            return 0;
        }
    }

    @Override
    public int countOfSurvives(boolean survived) {
        return 0;
    }

    @Override
    public int countOfSurvives(boolean survived, String sex) {
        return 0;
    }
}
