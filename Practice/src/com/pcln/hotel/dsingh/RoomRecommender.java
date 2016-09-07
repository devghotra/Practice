package com.pcln.hotel.dsingh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.pcln.hotel.HotelRoom;
import com.pcln.hotel.HotelRoom.Occupancy;
import com.pcln.hotel.HotelRoom.RoomInfo;

public class RoomRecommender {

	public static void main(String[] args) {

	}

	public List<HotelRoom> recommend(List<HotelRoom> availableRooms, int guests) {
		Map<Integer, Queue<HotelRoom>> roomsByOccupancyMap = convertToMap(availableRooms);
		
		int maxOccupany = Occupancy.getMaxOcupancy();
		RoomInfo[][] dp = new RoomInfo[maxOccupany+1][guests+1];
		
		// base cases
		for(int j=0; j<=guests; j++){
			dp[0][j] = new RoomInfo(Float.MAX_VALUE, null);
		}
		
		for(int i=0; i<=maxOccupany; i++){
			Queue<HotelRoom> roomsQ = roomsByOccupancyMap.get(i);
			HotelRoom room = roomsQ.poll();
			dp[i][0] = new RoomInfo(room != null ? room.price : Float.MAX_VALUE, room);
		}
		
		for(int i=1; i<=maxOccupany; i++){
			for(int j=1; j<=guests; j++){
				RoomInfo r1 = dp[i][j-i];
				RoomInfo r2 = dp[i-1][j];
				
				int guestsRemaining = j-i;
				float additionalPrice = 0;
				HotelRoom additionalRoom = null;
				if(guestsRemaining > 0){
					Queue<HotelRoom> roomsQ = roomsByOccupancyMap.get(i);
					HotelRoom room = roomsQ.poll();
					if(room != null){
						additionalPrice = room.price;
						additionalRoom = room;
					} else{
						
					}
				}
				
				RoomInfo r3 = new RoomInfo();
				if(r1.getTotalPrice() + additionalPrice <= r2.getTotalPrice()){
					r3.setTotalPrice(r1.getTotalPrice() + additionalPrice);
					r3.getRoomsUsed().addAll(r1.getRoomsUsed());
					if(additionalRoom != null)
						r3.getRoomsUsed().add(additionalRoom);
				} else{
					r3.setTotalPrice(r2.getTotalPrice());
					r3.getRoomsUsed().addAll(r2.getRoomsUsed());
				}
				
				dp[i][j] = r3;
			}
		}

		return null;
	}

	public static Map<Integer, Queue<HotelRoom>> convertToMap(List<HotelRoom> rooms) {
		Map<Integer, Queue<HotelRoom>> map = new HashMap<>();
		for (HotelRoom room : rooms) {
			if (map.get(room.getOccupancy()) != null)
				map.get(room.getOccupancy()).add(room);

			else {
				Queue<HotelRoom> queue = new PriorityQueue<>();
				queue.add(room);
				map.put(room.getOccupancy().getValue(), queue);
			}
		}
		return map;
	}

}

