package adjuster.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import adjuster.model.Friday13Adjuster;
import adjuster.model.WorkingDaysAdjuster;

class AdjustersTest {
	LocalDate date = LocalDate.of(2021, 8, 12);

	@Test
	void testFriday13() {
		LocalDate date = LocalDate.of(2021, 8, 15);
		LocalDate expected = LocalDate.of(2022, 5, 13);
		assertEquals(expected, date.with(new Friday13Adjuster()));
		assertEquals(expected, expected.with(new Friday13Adjuster()));
	}

	@Test
	void testIsraelWorkingDays() {
		DayOfWeek[] daysOff = {DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};
		LocalDate expected = LocalDate.of(2021, 8, 15);
		assertEquals(expected, date.with(new WorkingDaysAdjuster(1, daysOff)));
		expected = LocalDate.of(2021, 8, 19);
		assertEquals(expected, date.with(new WorkingDaysAdjuster(5, daysOff)));
	}
	
	@Test
	void testEuropeWorkingDays() {
		DayOfWeek[] daysOff = {DayOfWeek.SUNDAY, DayOfWeek.SATURDAY};
		LocalDate expected = LocalDate.of(2021, 8, 13);
		assertEquals(expected, date.with(new WorkingDaysAdjuster(1, daysOff)));
		expected = LocalDate.of(2021, 8, 16);
		assertEquals(expected, date.with(new WorkingDaysAdjuster(2, daysOff)));
	}

}
