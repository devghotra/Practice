package com.practice.strings.interviewbit;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("MMDCCXLIX"));
	}

	public static int romanToInt(String s) {
		Map<Character, Integer> map = getRomanMap();
		int num = map.get(s.charAt(0));
		
		for (int i = 1; i < s.length(); i++) {
			char pc = s.charAt(i-1);
			char cc = s.charAt(i);
			
			if(map.get(pc) < map.get(cc)){
				num += map.get(cc) - 2 * map.get(pc);
			} else{
				num += map.get(cc);
			}
			
		}
		
		return num;
	}
	
	private static Map<Character, Integer> getRomanMap(){
		Map<Character, Integer> map = new HashMap<>();
		
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		return map;
	}

}
