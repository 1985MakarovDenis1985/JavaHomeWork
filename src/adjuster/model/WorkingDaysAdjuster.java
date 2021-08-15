package adjuster.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class WorkingDaysAdjuster implements TemporalAdjuster {
    int nDays;
    DayOfWeek[] daysOff;

    public WorkingDaysAdjuster(int nDays, DayOfWeek[] daysOff) {
        this.nDays = nDays;
        this.daysOff = daysOff;
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {


        LocalDate ld = LocalDate.from(temporal);

        for (int i = 0; i < nDays; i++) {
            ld = ld.plusDays(1);
            if (ld.getDayOfWeek() == daysOff[0]) {
                ld = ld.plusDays(2);
            }else if (ld.getDayOfWeek() == daysOff[1]){
                ld = ld.plusDays(2);
            }

        }
        return ld;

//        while ((temporal.get(ChronoField.DAY_OF_WEEK) == 5 && temporal.get(ChronoField.DAY_OF_MONTH) == 13) != true) {
//            temporal = temporal.plus(1, ChronoUnit.DAYS);
//        }
    }
}
