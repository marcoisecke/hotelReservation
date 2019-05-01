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

public class ReservationBusinessTest3 extends TestCase{
	
	private HotelBusiness hotelBusiness;
	
	@Before
	public void setUp() throws Exception{
		hotelBusiness = new HotelBusiness();
		hotelBusiness.defineSizeHotel(3);
	}
	
	/**
	 * 
	 */
	@Test
	public void testCheckDateAvailable(){
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(new Reservation(1, 3));
		reservations.add(new Reservation(2, 5));
		reservations.add(new Reservation(1, 9));
		reservations.add(new Reservation(0, 15));
		
		
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
