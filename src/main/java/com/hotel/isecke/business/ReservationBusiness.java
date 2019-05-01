package com.hotel.isecke.business;

import com.hotel.isecke.model.Reservation;

/**
 * @author marco
 */
public class ReservationBusiness {

		
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
