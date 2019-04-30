package com.hotel.isecke.hotelReservationAPP;

import java.util.Random;
import java.util.Scanner;

import com.hotel.isecke.business.HotelBusiness;
import com.hotel.isecke.business.ReservationBusiness;
import com.hotel.isecke.model.Reservation;

/**
 * @author marco
 */
public class App {

	/**
	 * Constants
	 */
	private static final int SIZE_HOTEL = 2;

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {
		
		HotelBusiness hotelBusiness = new HotelBusiness();
		ReservationBusiness reservationBusiness = new ReservationBusiness();
		hotelBusiness.defineSizeHotel(SIZE_HOTEL);
		
        while(0==0){
	        System.out.println("Start date");
	        Scanner myObj = new Scanner(System.in);  
	        
	        
	        int startDate = myObj.nextInt();
//	        int startDate =  getRandomNumberInRange(0,99);
	        System.out.println("End date");
	        int endDate = myObj.nextInt();
	        //int endDate = getRandomNumberInRange(startDate,99);
	        
	        
	        reservationBusiness.verificaDataValida(startDate,endDate);
	        Reservation reservation = new Reservation(startDate,endDate);
	        hotelBusiness.checkAvailableroom(reservation);
        }
    }
	
	/**
	 * randon de numero
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
}
