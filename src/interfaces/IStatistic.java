package interfaces;

public interface IStatistic {
    double getTotalFares();
    double getAverageFaresForClasses(int classOfTravel);
    int getCountOfSurvives(boolean survived);
    int getCountOfSurvives(boolean survived, String sex);
}
