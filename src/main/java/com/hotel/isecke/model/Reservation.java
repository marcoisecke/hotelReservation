package com.hotel.isecke.model;

import java.lang.reflect.Constructor;

/**
 * @author marco
 */
public class Reservation {

	private int startDay;
	private int endDay;

	/**
	 * {@link Constructor}
	 * @param startDate
	 * @param endDate
	 */
	public Reservation(int startDay, int endDay) {
		this.startDay = startDay;
		this.endDay = endDay;
	}

	/************************ getters and setters ************************/

	/**
	 * @return the startDay
	 */
	public int getStartDay() {
		return startDay;
	}

	/**
	 * @param startDay
	 *            the startDay to set
	 */
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	/**
	 * @return the endDay
	 */
	public int getEndDay() {
		return endDay;
	}

	/**
	 * @param endDay
	 *            the endDay to set
	 */
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

}
