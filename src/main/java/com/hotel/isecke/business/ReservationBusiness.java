package com.hotel.isecke.business;

import com.hotel.isecke.model.Reservation;

/**
 * @author marco
 */
public class ReservationBusiness {

	private static final String HOTEL_FULL_MESSAGE = "We apologize, our hotel can be booked one year in advance";

	/**
	 * Make valid that the booking is just in one year
	 * 
	 * @param startDate
	 * @param endDate
	 * @throws Exception
	 */
	public void verificaDataValida(int startDate, int endDate) throws Exception {
		if (startDate < 0 || startDate > 365 && endDate < 0 || endDate > 365) {
			throw new Exception(HOTEL_FULL_MESSAGE);
		}
	}

	/**
	 * Method responsible for check if the room is available on the requested
	 * date
	 * 
	 * @param reservation
	 * @param res
	 * @return
	 */
	public boolean checkDateAvailable(Reservation reservation, Reservation res) {
		return (reservation.getStartDay() > res.getStartDay() && reservation.getStartDay() > res.getEndDay()
				&& reservation.getEndDay() > res.getStartDay() && reservation.getEndDay() > res.getEndDay())

				||

				(reservation.getStartDay() < res.getStartDay() && reservation.getStartDay() < res.getEndDay()
				&& reservation.getEndDay() < res.getStartDay() && reservation.getEndDay() < res.getEndDay());
	}

}
