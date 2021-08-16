package adjuster.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Arrays;

public class WorkingDaysAdjuster implements TemporalAdjuster {
    int nDays;
    DayOfWeek[] daysOff;

    public WorkingDaysAdjuster(int nDays, DayOfWeek[] daysOff) {
        this.nDays = nDays;
        this.daysOff = daysOff;
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        while (nDays > 0) {
            // нужно отсортировать массив DayOfWeek[] daysOff;
            Arrays.sort(daysOff);
            temporal = temporal.plus(1, ChronoUnit.DAYS);
            for (int i = 0; i < daysOff.length; i++) {
                if (temporal.get(ChronoField.DAY_OF_WEEK) == daysOff[i].getValue()) {
                    temporal = temporal.plus(1, ChronoUnit.DAYS);
                }
            }
            nDays--;
        }

//      solution by while:
//        while (nDays > 0){
//            temporal = temporal.plus(1, ChronoUnit.DAYS);
//            if (temporal.get(ChronoField.DAY_OF_WEEK) == daysOff[0].getValue()) {
//                temporal = temporal.plus(2, ChronoUnit.DAYS);
//            } else if (temporal.get(ChronoField.DAY_OF_WEEK) == daysOff[1].getValue()) {
//                temporal = temporal.plus(2, ChronoUnit.DAYS);
//            }
//            nDays--;
//        }

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


