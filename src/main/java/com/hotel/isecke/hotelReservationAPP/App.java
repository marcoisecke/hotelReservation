package com.hotel.isecke.hotelReservationAPP;

import java.util.Scanner;

import com.hotel.isecke.business.HotelBusiness;
import com.hotel.isecke.model.Reservation;

/**
 * @author marco
 */
public class App {

	private static final String START_DATE = "Type the start date of booking!";
	private static final String END_DATE = "Type the end date of booking!";
	private static final String SIZE_HOTEL = "Type the size of the Hotel";

	private static HotelBusiness hotelBusiness = new HotelBusiness();

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		Scanner myObj = new Scanner(System.in);
		System.out.println(SIZE_HOTEL);
		hotelBusiness.defineSizeHotel(myObj.nextInt());

		while (true) {
			System.out.println(START_DATE);
			int startDate = myObj.nextInt();
			System.out.println(END_DATE);
			int endDate = myObj.nextInt();

			Reservation reservation = new Reservation(startDate, endDate);
			hotelBusiness.checkAvailableroom(reservation);
		}
	}
}