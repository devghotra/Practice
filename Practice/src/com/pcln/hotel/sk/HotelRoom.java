package com.pcln.hotel.sk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.pcln.hotel.HotelRoom.Occupancy;

public class HotelRoom{
	public HotelRoom() {
		// TODO Auto-generated constructor stub
	}
	String roomId;
	Float price;
	Occupancy maxOccupancy;
	
	public HotelRoom(String roomId, float price, Occupancy maxOccupancy) {
		super();
		this.roomId = roomId;
		this.price = price;
		this.maxOccupancy = maxOccupancy;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*					3  
						/   |   \     \
					   /    |    \     |
				1s,1s,1s  2d,1s  1th,0  4q,0

		 */
		HotelRoom one1 = new HotelRoom("S1",50.0f,Occupancy.ONE);
		HotelRoom one2 = new HotelRoom("S2",30.0f,Occupancy.ONE);
		HotelRoom one3 = new HotelRoom("S3",30.0f,Occupancy.ONE);
		//HotelRoom two1 = new HotelRoom("D1",40.0f,Occupancy.TWO);
		HotelRoom two2 = new HotelRoom("D2",60.0f,Occupancy.TWO);
		HotelRoom three1 = new HotelRoom("TH1",180.0f,Occupancy.THREE);
		//HotelRoom three2 = new HotelRoom("TH2",100.0f,Occupancy.THREE);
		HotelRoom quad1 = new HotelRoom("Q1",900.0f,Occupancy.FOUR);
		Map<Integer,Queue<HotelRoom>> roomsMap = new HashMap<>();
		Queue<HotelRoom> priority3 = new PriorityQueue<HotelRoom>(
				new Comparator<HotelRoom>() {

					@Override
					public int compare(HotelRoom o1, HotelRoom o2) {
						return o1.price.compareTo(o2.price);
					}

				});
		priority3.offer(three1);
		//priority3.offer(three2);

		Queue<HotelRoom> priority2 = new PriorityQueue<HotelRoom>(
				new Comparator<HotelRoom>() {

					@Override
					public int compare(HotelRoom o1, HotelRoom o2) {
						return o1.price.compareTo(o2.price);
					}

				});
		//priority2.offer(two1);
		priority2.offer(two2);

		Queue<HotelRoom> priority1 = new PriorityQueue<HotelRoom>(
				new Comparator<HotelRoom>() {

					@Override
					public int compare(HotelRoom o1, HotelRoom o2) {
						return o1.price.compareTo(o2.price);
					}

				});
		priority1.offer(one1);
		priority1.offer(one2);
		priority1.offer(one3);
		Queue<HotelRoom> priority4 = new PriorityQueue<HotelRoom>(
				new Comparator<HotelRoom>() {

					@Override
					public int compare(HotelRoom o1, HotelRoom o2) {
						return o1.price.compareTo(o2.price);
					}

				});
		priority4.offer(quad1);

		roomsMap.put(Occupancy.THREE.getValue(),priority3);
		roomsMap.put(Occupancy.TWO.getValue(),priority2);
		roomsMap.put(Occupancy.ONE.getValue(),priority1);
		roomsMap.put(Occupancy.FOUR.getValue(),priority4);
		System.out.println(RateFinder.calculateBestOption(6, roomsMap).price);
	}
	
}
