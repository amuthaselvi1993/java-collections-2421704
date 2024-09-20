package com.linkedin.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookingService {

	private Map<Room, Guest> bookings = new HashMap<>();

	public boolean book(Room room, Guest guest) {

		/*
		 * 1. The provided Guest is placed in the bookings Map and
		 * associated with the provided room, only if no other guest
		 * is associated with the room.
		 * 
		 * Returns a boolean that indicates if the Guest was
		 * successfully placed in the room.
		 */
		Guest guest2 = bookings.putIfAbsent(room, guest);
			if(guest2 ==null)
				return true;
			else
				return false;
	}

	public double totalRevenue() {
		
		/*
		 * 2. Returns a double that totals the rate of each Room booked
		 * in the bookings Map.
		 */
		Set<Room> roomList = bookings.keySet();

		return roomList.stream().mapToDouble(r -> r.getRate()).sum();
	}
	
	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
