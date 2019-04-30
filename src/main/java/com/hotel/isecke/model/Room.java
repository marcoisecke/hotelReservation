package com.hotel.isecke.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marco
 */
public class Room {

	private int id;
	private List<Reservation> reservationDay;

	/**
	 * Constructor {@link Room}
	 * 
	 * @param startDate
	 * @param endDate
	 * @param id
	 */
	public Room(int startDate, int endDate, int id) {
		Reservation reservation = new Reservation(startDate, endDate);
		getReservationDay().add(reservation);
		this.id = id;

	}

	/************************ getters and setters ************************/

	/**
	 * @return the reservationDay
	 */
	public List<Reservation> getReservationDay() {
		if (reservationDay == null)
			reservationDay = new ArrayList<Reservation>();
		return reservationDay;
	}

	/**
	 * @param reservationDay
	 *            the reservationDay to set
	 */
	public void setReservationDay(List<Reservation> reservationDay) {
		this.reservationDay = reservationDay;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
