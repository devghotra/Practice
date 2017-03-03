package com.practice.strings.interviewbit;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreetyJson {

	public static void main(String[] args) {
		String json = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
		System.out.println(printJsonString(json));

	}

	public static String printJsonString(String jsonStr) {
		if (jsonStr == null || jsonStr.trim().length() == 0) {
			return jsonStr;
		}
		final String ret = "\n";
		StringBuilder formattedJson = new StringBuilder();
		StringBuilder spaces = new StringBuilder();
		//Deque<Character> Q = new ArrayDeque<>();
		for (int i = 0; i < jsonStr.length();) {
			char c = jsonStr.charAt(i);
			switch (c) {
				case '{':
				case '[':
					//Q.push(c);
					spaces.append("\t");
					formattedJson.append(c).append(ret).append(spaces);
					i++;
					break;
				case '}':
				case ']':
					//Q.pop();
					spaces.deleteCharAt(spaces.length() - 1);
					formattedJson.append(ret).append(spaces).append(c);
					i++;
					if (!(i < jsonStr.length() && jsonStr.charAt(i) == ',')) {
						formattedJson.append(ret).append(spaces);
					}
					break;
				case ',':
					formattedJson.append(c).append(ret).append(spaces);
					i++;
					break;
				default:
					formattedJson.append(c);
					i++;
					break;
			}
		}
		return formattedJson.toString();
	}
}
