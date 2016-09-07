package com.pcln.hotel.sk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.pcln.hotel.HotelRoom.Occupancy;

public class RateFinder {
	
	public static RoomInformation calculateBestOption(int guests,Map<Integer,Queue<HotelRoom>> roomsMap){
		int maxOccupanyForRoom = Occupancy.getMaxOcupancy();
		RoomInformation[][] dp = new RoomInformation[maxOccupanyForRoom+1][guests+1];
		// base case - row 0
		for(int i=1;i<=guests;i++){
			Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
			RoomInformation ri = new RoomInformation(roomsUsed,Float.MAX_VALUE,true);
			dp[0][i] = ri;

		}
		// base case - column 0
		for(int i=1;i<=maxOccupanyForRoom;i++){
			if(roomsMap.get(i)!=null && roomsMap.get(i).size()>0){
				Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
				roomsUsed.put(i, 0);
				RoomInformation ri = new RoomInformation(roomsUsed,0,true);
				dp[i][0] = ri;
			}else{
				RoomInformation previous = dp[i-1][0];
				Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
				roomsUsed.putAll(previous.roomsUsed);
				RoomInformation ri = new RoomInformation(roomsUsed,previous.price,false);
				dp[i][0] = ri;
			}
		}
		for(int i=1;i<=maxOccupanyForRoom;i++){
			for(int j=1;j<=guests;j++){
				RoomInformation withoutCurrentOccupancy = dp[i-1][j];
				if(j<i){
					HotelRoom room = getNextAvailableRommOfThatOccupancy(i,0,roomsMap);
					if(room!=null){
						Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
						roomsUsed.put(i, 1);
						RoomInformation ri = new RoomInformation(roomsUsed,room.price ,true);
						Map<Integer,Integer> previousRoomsUsed = new HashMap<Integer, Integer>();
						previousRoomsUsed.putAll(withoutCurrentOccupancy.roomsUsed);
						RoomInformation previous = new RoomInformation(previousRoomsUsed,withoutCurrentOccupancy.price,true);
						dp[i][j] = withoutCurrentOccupancy.price>room.price?ri:previous;
					}else{
						RoomInformation previous = dp[i-1][j];
						Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
						roomsUsed.putAll(previous.roomsUsed);
						RoomInformation ri = new RoomInformation(roomsUsed,previous.price,false);
						dp[i][j] = ri;	
					}
					continue;
				}
				RoomInformation withCurrentOccupancy = dp[i][j-i];
				if(withCurrentOccupancy.availableMore){
					int currentUsedRommOfThatOccupancy = 	withCurrentOccupancy.roomsUsed.get(i)!=null?withCurrentOccupancy.roomsUsed.get(i):0;
					HotelRoom nextAvailable = getNextAvailableRommOfThatOccupancy(i,currentUsedRommOfThatOccupancy,roomsMap);
					if(nextAvailable!=null){
						RoomInformation previos = new RoomInformation(withoutCurrentOccupancy.roomsUsed,withoutCurrentOccupancy.price,true);
						Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
						roomsUsed.putAll(withCurrentOccupancy.roomsUsed);
						int oldOccupied = roomsUsed.get(i)!=null?roomsUsed.get(i):0;
						roomsUsed.put(i, oldOccupied+1);
						RoomInformation ri = new RoomInformation(roomsUsed,nextAvailable.price + withCurrentOccupancy.price,true);
						//dp[i][j] = (ri.price>withoutCurrentOccupancy.price)?withoutCurrentOccupancy:ri;
						dp[i][j] = (ri.price>withoutCurrentOccupancy.price)?previos:ri;
					}else{
						RoomInformation haveToUsePreviousRoomsForRemaining = dp[i-1][j-i];
						Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
						roomsUsed.putAll(haveToUsePreviousRoomsForRemaining.roomsUsed);
						int oldOccupied = roomsUsed.get(i)!=null?roomsUsed.get(i):0;
						roomsUsed.put(i, oldOccupied+1);
						float allPricesofI = 0f;
						Queue<HotelRoom> allRoomsUsed = roomsMap.get(i);
						Iterator<HotelRoom> its = allRoomsUsed.iterator();
						while(its.hasNext()){
							allPricesofI+=its.next().price;
						}						
						RoomInformation ri = new RoomInformation(roomsUsed,haveToUsePreviousRoomsForRemaining.price + allPricesofI,false);
						dp[i][j] = ri;
					}
				}else{
					Map<Integer,Integer> roomsUsed = new HashMap<Integer, Integer>();
					roomsUsed.putAll(withoutCurrentOccupancy.roomsUsed);
					RoomInformation ri = new RoomInformation(roomsUsed,withoutCurrentOccupancy.price,false);
					dp[i][j] = ri;
				}
			}
		}
		return dp[maxOccupanyForRoom][guests];
	}
	//1. Single Room not available, but 1 adult and give one available r0om
		private static HotelRoom getNextAvailableRommOfThatOccupancy(int i, Integer currentUsedRommOfThatOccupancy,Map<Integer,Queue<HotelRoom>> roomsMap) {
			Queue<HotelRoom> rooms = new PriorityQueue<HotelRoom>(
					new Comparator<HotelRoom>() {
						@Override
						public int compare(HotelRoom o1, HotelRoom o2) {
							return o1.price.compareTo(o2.price);
						}
					});
			rooms.addAll(roomsMap.get(i));
			int required = currentUsedRommOfThatOccupancy + 1;
			int k =1;
			if(rooms.size()>0 && rooms.size() >= required){
				while(k<=required){
					HotelRoom requiredRoom =  rooms.poll();
					if(k==required){
						return requiredRoom;
					}
					k++;
				}
			}

			return null;
		}
}
class RoomInformation{
	Map<Integer,Integer> roomsUsed = new HashMap<>();
	float price;
	boolean availableMore;
	public RoomInformation(Map<Integer,Integer> roomsUsed,float price,boolean availableMore) {
		this.roomsUsed = roomsUsed;
		this.price = price;
		this.availableMore = availableMore;
	}
}