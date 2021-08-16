package adjuster.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.*;

public class Friday13Adjuster implements TemporalAdjuster {
//    @Override
//    public Temporal adjustInto(Temporal temporal) {
//        while (!(temporal.get(ChronoField.DAY_OF_WEEK) == 5 && temporal.get(ChronoField.DAY_OF_MONTH) == 13)) {
//               temporal = temporal.plus(1, ChronoUnit.DAYS);
//        }
//        return temporal;
//    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
// new solution
        Temporal date = temporal;
        temporal = temporal.with(ChronoField.DAY_OF_MONTH, 13);
        if (ChronoUnit.DAYS.between(date, temporal) < 0) {
            temporal = temporal.plus(1, ChronoUnit.MONTHS);
        }
        while (temporal.get(ChronoField.DAY_OF_WEEK) !=5) {
            temporal = temporal.plus(1, ChronoUnit.MONTHS);
        }

// new solution
//        temporal = temporal.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
//        while (temporal.get(ChronoField.DAY_OF_MONTH) != 13) {
//            temporal = temporal.plus(1, ChronoUnit.WEEKS);
//        }

// my solution
//        while (!(temporal.get(ChronoField.DAY_OF_WEEK) == 5 && temporal.get(ChronoField.DAY_OF_MONTH) == 13)) {
//            temporal = temporal.plus(1, ChronoUnit.DAYS);
//        }
        return temporal;
    }

}
