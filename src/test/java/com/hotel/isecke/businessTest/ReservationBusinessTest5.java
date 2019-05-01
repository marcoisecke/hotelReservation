package com.hotel.isecke.businessTest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.hotel.isecke.business.HotelBusiness;
import com.hotel.isecke.model.Reservation;

import junit.framework.TestCase;


/**
 * @author marco
 */

public class ReservationBusinessTest5 extends TestCase{
	
	private HotelBusiness hotelBusiness;
	
	@Before
	public void setUp() throws Exception{
		hotelBusiness = new HotelBusiness();
		hotelBusiness.defineSizeHotel(2);
	}
	
	/**
	 * 
	 */
	@Test
	public void testCheckDateAvailable(){
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(new Reservation(1, 3));
		reservations.add(new Reservation(0, 4));
		reservations.add(new Reservation(2, 3));
		reservations.add(new Reservation(5, 5));
		reservations.add(new Reservation(4, 10));
		reservations.add(new Reservation(10, 10));
		reservations.add(new Reservation(6, 7));
		reservations.add(new Reservation(8, 10));
		reservations.add(new Reservation(8, 9));
		
		
		
		//exe
		boolean result = false;
		try {
			result = hotelBusiness.checkAvailableroomList(reservations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(result);
	}

}
