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

//      solution by for:
        while (nDays > 0){
            temporal = temporal.plus(1, ChronoUnit.DAYS);
            if (temporal.get(ChronoField.DAY_OF_WEEK) == daysOff[0].getValue()) {
                temporal = temporal.plus(2, ChronoUnit.DAYS);
            } else if (temporal.get(ChronoField.DAY_OF_WEEK) == daysOff[1].getValue()) {
                temporal = temporal.plus(2, ChronoUnit.DAYS);
            }
            nDays--;
        }

//        solution by for:
//        for (int i = 0; i < nDays; i++) {
//            temporal = temporal.plus(1, ChronoUnit.DAYS);
//            if (temporal.get(ChronoField.DAY_OF_WEEK) == daysOff[0].getValue()) {
//                temporal = temporal.plus(2, ChronoUnit.DAYS);
//            } else if (temporal.get(ChronoField.DAY_OF_WEEK) == daysOff[1].getValue()) {
//                temporal = temporal.plus(2, ChronoUnit.DAYS);
//            }
//        }
        return temporal;
    }
}

// daysOff[0].getValue() -> цифровое значение дня недели;
// temporal.plus(2, ChronoUnit.DAYS) -> что - кого


