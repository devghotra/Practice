
package com.pcln.hotel.kv;

import java.util.*;

public class HotelRoomRecommenderKV {

	public static class HotelRoom implements Comparable<HotelRoom> {
		private String roomId;
		private float price;
		private Occupancy occupancy;

		public HotelRoom(String roomId, float price, Occupancy occupancy) {
			this.roomId = roomId;
			this.price = price;
			this.occupancy = occupancy;
		}

		public int compareTo(HotelRoom that) {
			if (this.getOccupancy() == that.getOccupancy())
				return Float.compare(this.getPrice(), that.getPrice());

			else {
				return 0; // if different occupancy, consider equal or cannot be
							// compared
			}
		}

		public String getRoomId() {
			return this.roomId;
		}

		public void setRoomId(String roomId) {
			this.roomId = roomId;
		}

		public float getPrice() {
			return this.price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public Occupancy getOccupancy() {
			return this.occupancy;
		}

		public void setOccupancy(Occupancy occupancy) {
			this.occupancy = occupancy;
		}
	}

	public static enum Occupancy {
		ONE(1), TWO(2), THREE(3), FOUR(4);

		private int value;

		private Occupancy(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	public static void main(String[] args) {

		HotelRoom room1 = new HotelRoom("1", 50.0f, Occupancy.ONE);
		HotelRoom room2 = new HotelRoom("2", 70.0f, Occupancy.TWO);
		HotelRoom room3 = new HotelRoom("3", 60.0f, Occupancy.TWO);
		HotelRoom room4 = new HotelRoom("4", 80.0f, Occupancy.THREE);
		HotelRoom room5 = new HotelRoom("5", 100.0f, Occupancy.THREE);
		HotelRoom room6 = new HotelRoom("6", 120.0f, Occupancy.FOUR);

		// assume this list comes from cache unsorted
		List<HotelRoom> list = new ArrayList<>();

		list.add(room1);
		list.add(room2);
		list.add(room3);
		list.add(room4);
		list.add(room5);
		list.add(room6);

		// convert list to map keyed by occupancy and valued by Priority Q
		// (ascending)
		Map<Occupancy, Queue<HotelRoom>> map = convertToMap(list);

		// this list holds the final result
		List<HotelRoom> result = new ArrayList<HotelRoom>();

		int adults = 2; // change this value to run different test scenarios

		recommend(adults, map, result, new ArrayList<HotelRoom>(), Float.MAX_VALUE, 0.0f);

		printList(adults, result);
	}

	public static float recommend(int target, Map<Occupancy, Queue<HotelRoom>> map, List<HotelRoom> result, List<HotelRoom> selected, float min, float net) {

		if (target == 0) {
			if (net < min) {
				result.clear();
				result.addAll(selected);
				min = net;
			}
			return min;
		}

		for (Occupancy occ : map.keySet()) {

			if (occ.getValue() > target)
				continue;

			Queue<HotelRoom> rooms = map.get(occ);
			if (rooms != null && !rooms.isEmpty()) {
				HotelRoom cheapestRoom = rooms.remove();
				selected.add(cheapestRoom);
				min = recommend(target - occ.getValue(), map, result, selected, min, net + cheapestRoom.getPrice());
				rooms.add(cheapestRoom);
				selected.remove(selected.size() - 1);
			}
		}
		return min;
	}

	public static Map<Occupancy, Queue<HotelRoom>> convertToMap(List<HotelRoom> rooms) {

		Map<Occupancy, Queue<HotelRoom>> map = new HashMap<>();

		for (HotelRoom room : rooms) {

			if (map.get(room.getOccupancy()) != null)
				map.get(room.getOccupancy()).add(room);

			else {
				Queue<HotelRoom> queue = new PriorityQueue<>();
				queue.add(room);
				map.put(room.getOccupancy(), queue);
			}
		}
		return map;
	}

	public static void printList(int adults, List<HotelRoom> list) {

		int count = 1;
		float price = 0.0f;

		System.out.println("Number of adults requested " + adults);

		for (HotelRoom room : list) {
			System.out.println("Room number " + count);
			System.out.println("Room occ " + room.getOccupancy().name() + " (" + room.getOccupancy().getValue() + ")");
			System.out.println("Room price " + room.getPrice());
			count++;
			price += room.getPrice();
		}
		System.out.println("Total price " + price);
	}
}
