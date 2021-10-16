package interfaces;

public interface IStatistic {
    double totalFares();
    double averageFaresForClasses(int classOfTravel);
    int countOfSurvives(boolean survived);
    int countOfSurvives(boolean survived, String sex);
}
