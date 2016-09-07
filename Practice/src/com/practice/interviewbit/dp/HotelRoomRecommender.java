package com.practice.interviewbit.dp;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class HotelRoomRecommender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Function<HotelRoom, Integer> occFunction = new Function<HotelRoom, Integer>(){
		@Override
		public Integer apply(HotelRoom room){
			return room.maxOccupancy.getValue();
		}
	};
	
	public int recommend(int requestedOccupancy, List<HotelRoom> availableRooms){
		
		Multimap<Integer, HotelRoom> roomsByOccupancy = Multimaps.index(availableRooms, occFunction);
		
		int[] dp = new int[requestedOccupancy];
		
		for(int i=1; i<=requestedOccupancy; i++){
			List<HotelRoom> rooms = (List<HotelRoom>) roomsByOccupancy.get(i);
			if(rooms != null){
				
			}
		}
		
		return 0;
	}

}

enum Occupancy {
	ONE(1), TWO(2), THREE(3), FOUR(4);

	private int value;

	private Occupancy(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

class HotelRoom {

	String roomId;
	float price;
	Occupancy maxOccupancy;

}
