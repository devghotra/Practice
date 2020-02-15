package com.practice.strings;

import java.util.ArrayList;

public class ValidIPAddresses {

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		int len = s.length();
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	private boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
			return false;
		return true;
	}


    /**
     * Recursive/Backtracking solution but above solution is simple to understand
     */
    public ArrayList<String> restoreIpAddresses_recursive(String s) {
        return parseIp(s, 4);
    }

    private ArrayList<String> parseIp(String s, int octets) {
        ArrayList<String> result = new ArrayList<>();

        if (octets == 1) {
            if (s.length() > 0 && s.length() <= 3) {
                Integer num = Integer.parseInt(s);
                if (num <= 255 && num.toString().equals(s)) {
                    result.add(s);
                }
            }
            return result;
        }

        for (int i = 0; i < 3; i++) {
            if (i + 1 <= s.length()) {
                Integer num = Integer.parseInt(s.substring(0, i + 1));
                if (num <= 255 && num.toString().equals(s.substring(0, i + 1))) {
                    ArrayList<String> res = parseIp(s.substring(i + 1), octets - 1);
                    for (int j = 0; j < res.size(); j++) {
                        res.set(j, num + "." + res.get(j));
                    }
                    result.addAll(res);
                }
            }
        }

        return result;
    }
}
