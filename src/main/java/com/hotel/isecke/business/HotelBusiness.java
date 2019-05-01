package com.hotel.isecke.business;

import java.util.ArrayList;
import java.util.List;

import com.hotel.isecke.model.Reservation;
import com.hotel.isecke.model.Room;

/**
 * @author marco
 */
public class HotelBusiness {

	private static final String BOOKING_DECLINED = "Booking Declined! We don't have vacancies.";
	private static final String HOTEL_LIMIT = "We just accepted 1000 rooms!";
	private static final String HOTEL_FULL_MESSAGE = "We apologize, our hotel can be booked one year in advance";
	public int tamanhoHotel;
	public List<Room> rooms;

	private ReservationBusiness reservationBusiness = new ReservationBusiness();

	/**
	 * Define how many rooms there are in the hotel
	 * 
	 * @throws Exception
	 */
	public void defineSizeHotel(int tamanhoHotel) throws Exception {
		if (tamanhoHotel > 1000) {
			throw new Exception(HOTEL_LIMIT);
		}
		setTamanhoHotel(tamanhoHotel);
	}

	/**
	 * Check if rooms is available
	 * 
	 * @param reservation
	 */
	public boolean checkAvailableroom(Reservation reservation) {

		if (reservation.getStartDay() < 0 || reservation.getStartDay() > 365 && reservation.getEndDay() < 0
				|| reservation.getEndDay() > 365) {
			System.out.println(HOTEL_FULL_MESSAGE);
			return false;
		}


		for (Room r : getRooms()) {
			if (r.getReservationDay().isEmpty()) {
				r.getReservationDay().add(reservation);
				messageSuc();
				return true;
			}

			boolean roomAvailable = true;
			for (Reservation res : r.getReservationDay()) {
				if (!reservationBusiness.checkDateAvailable(reservation, res)) {
					roomAvailable = false;
				}
			}
			if (roomAvailable) {
				r.getReservationDay().add(reservation);
				messageSuc();
				return true;
			}
		}
		
		if (getTamanhoHotel() < getRooms().size() +1) {
			System.out.println(BOOKING_DECLINED);
			return false;
		}

		createRoom(reservation);
		return true;
	}

	/**
	 * 
	 * @param reservations
	 * @return
	 */
	public boolean checkAvailableroomList(List<Reservation> reservations) {
		reservations.stream().forEach(r -> checkAvailableroom(r));
		return true;
	}

	/**
	 * Method responsible for create Room and Reservations
	 * 
	 * @param reservation
	 */
	private void createRoom(Reservation reservation) {
		getRooms().add(new Room(reservation.getStartDay(), reservation.getEndDay(), getRooms().size() + 1));
		messageSuc();
	}

	/**
	 * message successful
	 */
	private void messageSuc() {
		System.out.println("Booking Accepted!Enjoy your stay.");
	}

	/************************ getters and setters ************************/

	/**
	 * @return the rooms
	 */
	public List<Room> getRooms() {
		if (rooms == null)
			rooms = new ArrayList<Room>();
		return rooms;
	}

	/**
	 * @param rooms
	 *            the rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the tamanhoHotel
	 */
	public int getTamanhoHotel() {
		return tamanhoHotel;
	}

	/**
	 * @param tamanhoHotel
	 *            the tamanhoHotel to set
	 */
	public void setTamanhoHotel(int tamanhoHotel) {
		this.tamanhoHotel = tamanhoHotel;
	}

}
