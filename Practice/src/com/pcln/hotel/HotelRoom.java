package com.pcln.hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRoom implements Comparable<HotelRoom> {
	public String roomId;
	public float price;
	public Occupancy occupancy;

	public HotelRoom(String roomId, float price, Occupancy occupancy) {
		this.roomId = roomId;
		this.price = price;
		this.occupancy = occupancy;
	}

	public Occupancy getOccupancy() {
		return occupancy;
	}

	public int compareTo(HotelRoom that) {
		if (this.occupancy == that.occupancy)
			return Float.compare(price, price);

		else {
			return 0;
		}
	}
	
	public static enum Occupancy {
		ONE(1), TWO(2), THREE(3), FOUR(4);

		private int value;

		private Occupancy(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static Integer getMaxOcupancy() {
			return FOUR.getValue();
		}

	}
	
	public static class RoomInfo{
		List<HotelRoom> roomsUsed = new ArrayList<>();
		float totalPrice;
		
		public RoomInfo(){
			super();
		}
		
		public RoomInfo(float totalPrice, HotelRoom room) {
			super();
			this.totalPrice = totalPrice;
			if(room != null)
				roomsUsed.add(room);
		}
		
		public List<HotelRoom> getRoomsUsed() {
			return roomsUsed;
		}
		public void setRoomsUsed(List<HotelRoom> roomsUsed) {
			this.roomsUsed = roomsUsed;
		}
		public float getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}
		
		public void addRoom(HotelRoom room){
			roomsUsed.add(room);
		}
		
	}
}


