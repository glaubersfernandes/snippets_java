package br.com.gftecnologia.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateDifferenceSnippet {

	/**
	 * This function calculates the number of years between two LocalDate objects.
	 * If the result is negative, it returns the absolute value of the difference.
	 * 
	 * @param firstTime The first LocalDate object representing the starting date
	 * @param secondTime The second LocalDate object representing the ending date
	 * @return The number of years between the two LocalDate objects as a long data type
	 */
	public static long getYearsDifference(LocalDate firstTime, LocalDate secondTime) {
		var yearsDifference = ChronoUnit.YEARS.between(firstTime, secondTime);
		return Math.abs(yearsDifference);
	}

	/**
	 * This function calculates the number of months between two LocalDate objects.
	 * If the result is negative, it returns the absolute value of the difference.
	 * 
	 * @param firstTime The first LocalDate object representing the starting date
	 * @param secondTime The second LocalDate object representing the ending date
	 * @return The number of months between the two LocalDate objects as a long data type
	 */
	public static long getMonthsDifference(LocalDate firstTime, LocalDate secondTime) {
		var monthsDifference = ChronoUnit.MONTHS.between(firstTime, secondTime);
		return Math.abs(monthsDifference);
	}

	/**
	 * This function calculates the number of days between two LocalDate objects.
	 * If the result is negative, it returns the absolute value of the difference.
	 * 
	 * @param firstTime The first LocalDate object representing the starting date
	 * @param secondTime The second LocalDate object representing the ending date
	 * @return The number of days between the two LocalDate objects as a long data type
	 */
	public static long getDaysDifference(LocalDate firstTime, LocalDate secondTime) {
		var daysDifference = ChronoUnit.DAYS.between(firstTime, secondTime);
		return Math.abs(daysDifference);
	}
}
