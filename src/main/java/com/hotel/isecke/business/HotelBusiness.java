package com.hotel.isecke.business;

import java.util.ArrayList;
import java.util.List;

import com.hotel.isecke.model.Reservation;
import com.hotel.isecke.model.Room;

/**
 * @author marco
 */
public class HotelBusiness {

	private static final String HOTEL_FULL_MESSAGE = "We don't have vacancies!";
	public int tamanhoHotel;
	public List<Room> rooms;
	
	private ReservationBusiness reservationBusiness = new ReservationBusiness();

	/**
	 * Define how many rooms there are in the hotel
	 */
	public void defineSizeHotel(int tamanhoHotel) {
		setTamanhoHotel(tamanhoHotel);
	}

	/**
	 * Check if rooms is available
	 * 
	 * @param reservation
	 */
	public void checkAvailableroom(Reservation reservation) throws Exception {
		for (Room r : getRooms()) {
			if (r.getReservationDay().isEmpty()) {
				r.getReservationDay().add(reservation);
				return;
			}

			boolean roomAvailable = true;
			for (Reservation res : r.getReservationDay()) {
				if (!reservationBusiness.checkDateAvailable(reservation, res)) {
					roomAvailable = false;
				}
			}
			if (roomAvailable) {
				r.getReservationDay().add(reservation);
				return;
			}
		}

		checkHotelFull();
		createRoom(reservation);
	}

	/**
	 * Check if the hotel is full.
	 * 
	 * @throws Exception
	 */
	private void checkHotelFull() throws Exception {
		if (getTamanhoHotel() < getRooms().size() + 1) {
			throw new Exception(HOTEL_FULL_MESSAGE);
		}
	}

	/**
	 * Method responsible for create Room and Reservations
	 * 
	 * @param reservation
	 */
	private void createRoom(Reservation reservation) {
		getRooms().add(new Room(reservation.getStartDay(), reservation.getEndDay(), getRooms().size() + 1));

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
