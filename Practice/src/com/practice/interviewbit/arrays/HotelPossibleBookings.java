package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelPossibleBookings {

	public static void main(String[] args) {
		//Integer[] arrivalArr = {13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8};
		//Integer[] departArr =  {28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53};
		
		Integer[] arrivalArr = {40, 18};
		Integer[] departArr =  {40, 43};
		
		
		boolean bln = hotel(Arrays.asList(arrivalArr), Arrays.asList(departArr), 1);
		System.out.println(bln);
		
	}
	
	// solution on IB, seems like not correct
	public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
		Collections.sort(arrive);
		Collections.sort(depart);
		int ar = 0, de = 0, nos = 0, satisfy = 0;
		while (ar < arrive.size() && de < depart.size()) {
			if (arrive.get(ar) < depart.get(de)) {
				ar++;
				nos++;
				satisfy = Math.max(nos, satisfy);
			} else {
				de++;
				nos--;
			}
		}
		return (satisfy <= K) ? true : false;
	}
	
	public static boolean hotel1(List<Integer> arrive, List<Integer> depart, int K) {
		Comparator<HotelBooking> comparator = new Comparator<HotelBooking>() {

			@Override
			public int compare(HotelBooking o1, HotelBooking o2) {
				if(o1.arrival < o2.arrival)
					return -1;
				else if(o1.arrival > o2.arrival)
					return 1;
				else
					return 0;
				
			}};
		
		List<HotelBooking> bookingList = new ArrayList<>();
		
		for(int i=0; i<arrive.size(); i++){
			bookingList.add(new HotelBooking(arrive.get(i), depart.get(i)));
		}
		
		Collections.sort(bookingList, comparator);
		
		List<Integer> departDates = new ArrayList<>();
		int roomsBooked = 0;
		
		for(HotelBooking hb : bookingList){
			boolean roomAvailable = false;
			if(roomsBooked < K){
				departDates.add(hb.departure);
				roomsBooked++;
				roomAvailable = true;
			} else{
				for(int i=0; i<K; i++){
					if(hb.arrival >= departDates.get(i)){
						departDates.set(i, hb.departure);
						roomAvailable = true;
						break;
					}
				}
			}	
			
			if(!roomAvailable)
				return false;
		}
		
		return true;
    }

}

class HotelBooking {
	int arrival;
	int departure;
	
	public HotelBooking(int arrival, int departure) {
		super();
		this.arrival = arrival;
		this.departure = departure;
	}
}
