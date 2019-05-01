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

public class ReservationBusinessTest2 extends TestCase{
	
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
		reservations.add(new Reservation(0, 5));
		reservations.add(new Reservation(7, 13));
		reservations.add(new Reservation(3, 9));
		reservations.add(new Reservation(5, 7));
		reservations.add(new Reservation(6, 6));
		reservations.add(new Reservation(0, 4));
		
		
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
