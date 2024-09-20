package com.linkedin.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list.
		 */
//		List<Guest> favouriteRoom = new ArrayList<>();
		return guests.stream().filter(g-> g.getPreferredRooms().indexOf(room)==0).collect(Collectors.toList());
//		for(Guest guest:guests)
//		{
//			if(guest.getPreferredRooms().size()>0 &&
//					guest.getPreferredRooms().get(0)!=null &&
//					room == (guest.getPreferredRooms().get(0)))
//				favouriteRoom.add(guest);
//		}
//
//		return favouriteRoom;

	}
	private int position  = 0;
	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */

		if(guest.isLoyaltyProgramMember()) {
			checkinList.add(position, guest);
			position= position+1;
			System.out.println("Name "+ guest.getFirstName() + "position " +position);
		}
		else
			checkinList.add(guest);

	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */
			if(this.checkinList.contains(guest1)
				&& this.checkinList.contains(guest2))
			{
				int g1pos = this.checkinList.indexOf(guest1);
				int g2pos = this.checkinList.indexOf(guest2);
				this.checkinList.set(g1pos, guest2);
				this.checkinList.set(g2pos,guest1);
			}
	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
